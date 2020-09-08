package pudding.commands.member_commands;

import pudding.Utility.enums.PuddingTextChannels;
import pudding.Utility.permissions.Pudding;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;
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
        Pudding pudding = new Pudding(e.getMember());
        if (pudding.isVerified()) {
            e.getAuthor().openPrivateChannel().queue((privateChannel -> {
                privateChannel.sendMessage(prompt().build()).queue();
            }));
            waiter.waitForEvent(PrivateMessageReceivedEvent.class, event1 -> event1.getAuthor().equals(e.getAuthor()), event1 -> {
                e.getAuthor().openPrivateChannel().queue((privateChannel -> {
                    privateChannel.sendMessage(prompt2().build()).queue();
                }));
                Objects.requireNonNull(
                        e.getGuild().getTextChannelById(PuddingTextChannels.STAFF_QUEUE.getTextChannelId()))
                        .sendMessage(event1.getMessage()
                                .getAttachments()
                                .get(0)
                                .getUrl()).queue();

                waiter.waitForEvent(PrivateMessageReceivedEvent.class, event2 -> event2.getAuthor().equals(e.getAuthor()), event2 -> {
                    e.getAuthor().openPrivateChannel().queue((privateChannel -> {
                        privateChannel.sendMessage(finalPrompt().build()).queue();
                    }));
                    Objects.requireNonNull(
                            e.getGuild().getTextChannelById(PuddingTextChannels.STAFF_QUEUE.getTextChannelId()))
                            .sendMessage(event2.getMessage()
                                    .getAttachments()
                                    .get(0)
                                    .getUrl()).queue();
                }, 5, TimeUnit.MINUTES, () -> e.getAuthor().openPrivateChannel().queue((privateChannel -> {
                    privateChannel.sendMessage(verifyCancelled().build()).queue();
                })));
            }, 5, TimeUnit.MINUTES, () -> e.getAuthor().openPrivateChannel().queue((privateChannel -> {
                privateChannel.sendMessage(verifyCancelled().build()).queue();
            })));
        } else {
            e.getMember().getUser().openPrivateChannel().queue((privateChannel -> privateChannel.sendMessage(alreadyVerified().build()).queue()));
        }
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
