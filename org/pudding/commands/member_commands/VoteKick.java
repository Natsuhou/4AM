package org.pudding.commands.member_commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;

import java.util.Objects;

public class VoteKick extends Command {
    private final EventWaiter waiter;
    public VoteKick(EventWaiter w) {
        super.name = "vk";
        super.cooldown = 50;
        this.waiter = w;
    }

    /*
    User types: !vk @Username
    Bot creates an embedbuilder with the person's reaction as a checkmark at the start or something

     */
    @Override
    protected void execute(CommandEvent e) {
        if (!e.getArgs().isEmpty()) {
            if (e.getMessage().getMentionedUsers().isEmpty()) {
                if (Objects.requireNonNull(e.getMember().getVoiceState()).inVoiceChannel() && e.getMember().getVoiceState().getChannel().getMembers().size() >= 2) {

                    int totalInChannel = Objects.requireNonNull(e.getMember().getVoiceState().getChannel()).getMembers().size();
                    String[] userId = new String[totalInChannel];

                    for (int i = 1; i < totalInChannel; i++) {
                        userId[i] = e.getMember().getVoiceState().getChannel().getMembers().get(i).getId();
                    }

                    e.getChannel().sendMessage(voteKick(e).build()).queue();

                    e.getChannel().getLatestMessageId();

                } else {

                }
            } else {
                e.reply(noArgs().build());
            }
        } else {
            e.getChannel().sendMessage(noArgs().build()).queue();
        }
    }
    private EmbedBuilder noArgs() {
        return new EmbedBuilder()
                .setTitle("No args");
    }
    private EmbedBuilder voteKick(CommandEvent e) {
        return new EmbedBuilder()
                .setAuthor(e.getAuthor().getName(), null, e.getAuthor().getAvatarUrl())
                .setTitle("Votekick for " + e.getMessage().getMentionedUsers().get(0).getName() + " has begun!")
                .setDescription("Reason for vote: " + e.getArgs())
                .setFooter("Contact a staff member for further help!", "https://i.imgur.com/QDWW5Bq.png");
    }
    private EmbedBuilder voteKickTimeout(CommandEvent e) {
        return new EmbedBuilder()
                .setAuthor(e.getAuthor().getName(), null, e.getAuthor().getAvatarUrl())
                .setTitle("Votekick has been cancelled!")
                .setDescription("Reason for cancellation: Not all users have voted!");
    }
}
