package org.pudding.commands.member_commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class GetDiscordProfileIcon extends Command {
    public GetDiscordProfileIcon() {
        super.name = "gpi";
        super.cooldown = 5;
    }

    @Override
    protected void execute(CommandEvent e) {
        if (!e.getArgs().isEmpty()) {
            if (!e.getMessage().getMentionedUsers().isEmpty()) {
                e.reply(e.getMessage().getMentionedUsers().get(0).getAvatarUrl());
            } else {
                e.reply(noMentionedUsers().build());
            }
        } else {
            e.reply(e.getAuthor().getAvatarUrl());
        }
    }
    private EmbedBuilder noMentionedUsers() {
        return new EmbedBuilder()
                .setTitle("No mentioned users!")
                .setColor(new Color(255, 138, 138))
                .setDescription("Please mention a user to use this command!")
                .setFooter("Contact a staff member for further help!", "https://i.imgur.com/QDWW5Bq.png");
    }
}
