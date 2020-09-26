package org.pudding.commands.member_commands;

import org.pudding.utility.enums.PuddingRoles;
import org.pudding.utility.enums.PuddingTextChannels;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Verification extends Command {
    private final EventWaiter waiter;

    public Verification(EventWaiter w) {
        super.name = "verify";
        super.cooldown = 5;
        waiter = w;
    }

    @Override
    protected void execute(@NotNull CommandEvent e) {
        if (PuddingRoles.isVerified(e.getMember())) {
            e.getAuthor().openPrivateChannel().queue((privateChannel -> privateChannel.sendMessage(prompt().build()).queue()));
            waiter.waitForEvent(PrivateMessageReceivedEvent.class,
                    privateMessageReceivedEvent -> privateMessageReceivedEvent.getAuthor().equals(e.getAuthor()),
                    privateMessageReceivedEvent -> {
                        handleFirstVerification(e, privateMessageReceivedEvent);
                        waiter.waitForEvent(PrivateMessageReceivedEvent.class,
                                privateMessageReceivedEvent1 -> privateMessageReceivedEvent1.getAuthor().equals(e.getAuthor()),
                                privateMessageReceivedEvent1 -> handleSecondVerification(e, privateMessageReceivedEvent1),
                                5, TimeUnit.MINUTES, () -> e.getAuthor().openPrivateChannel().queue(
                                        privateChannel -> privateChannel.sendMessage(verifyCancelled().build()).queue()
                                )
                        );
                    }, 5, TimeUnit.MINUTES, () -> e.getAuthor().openPrivateChannel().queue(
                            privateChannel -> privateChannel.sendMessage(verifyCancelled().build()).queue()
                    ));
        } else {
            e.getMember().getUser().openPrivateChannel().queue((privateChannel -> privateChannel.sendMessage(alreadyVerified().build()).queue()));
        }
    }
    private void handleFirstVerification(CommandEvent commandEvent, PrivateMessageReceivedEvent privateMessageReceivedEvent) {
        commandEvent.getAuthor().openPrivateChannel().queue((privateChannel -> privateChannel.sendMessage(prompt2().build()).queue()));
        commandEvent.getGuild().getTextChannelById(PuddingTextChannels.STAFF_QUEUE.getTextChannelId())
                .sendMessage(privateMessageReceivedEvent
                        .getMessage()
                        .getAttachments()
                       .get(0)
                        .getUrl()
                ).queue();
    }
    private void handleSecondVerification(CommandEvent commandEvent, PrivateMessageReceivedEvent privateMessageReceivedEvent) {
        commandEvent.getAuthor().openPrivateChannel().queue(
                privateChannel -> privateChannel.sendMessage(finalPrompt().build()).queue()
        );
        commandEvent.getGuild().getTextChannelById(PuddingTextChannels.STAFF_QUEUE.getTextChannelId())
                .sendMessage(privateMessageReceivedEvent
                        .getMessage()
                        .getAttachments()
                        .get(0)
                        .getUrl())
                .queue();
    }
    private @NotNull EmbedBuilder prompt() {
        return new EmbedBuilder()
                .setTitle("1. First image")
                .setColor(new Color(255, 183, 138))
                .setDescription("Please send the first verification image (order doesn't matter)!")
                .setFooter("Contact a staff member for further help!", "https://i.imgur.com/QDWW5Bq.png");
    }
    private @NotNull EmbedBuilder prompt2() {
        return new EmbedBuilder()
                .setTitle("2. Second image")
                .setColor(new Color(255, 183, 138))
                .setDescription("Please send the second verification image!")
                .setFooter("Contact a staff member for further help!", "https://i.imgur.com/QDWW5Bq.png");
    }
    private @NotNull EmbedBuilder finalPrompt() {
        return new EmbedBuilder()
                .setTitle("✔ Verification completed!")
                .setColor(new Color(163, 255, 138))
                .setDescription("You've sent all the required documents to verify! We'll update you later!")
                .setFooter("Contact a staff member for further help!", "https://i.imgur.com/QDWW5Bq.png");
    }
    private @NotNull EmbedBuilder verifyCancelled() {
        return new EmbedBuilder()
                .setColor(new Color(255, 138, 138))
                .setTitle("❌ Member Verification Cancelled!")
                .setDescription("Please type the verification command in the server again to redo verification!")
                .setFooter("Contact a staff member for further help!", "https://i.imgur.com/QDWW5Bq.png");
    }
    private @NotNull EmbedBuilder alreadyVerified() {
        return new EmbedBuilder()
                .setColor(new Color(255, 138, 138))
                .setTitle("Account Already Verified!")
                .setDescription("You cannot verify your account as you've already been verified!")
                .setFooter("Contact a staff member for further help!", "https://i.imgur.com/QDWW5Bq.png");
    }
}
