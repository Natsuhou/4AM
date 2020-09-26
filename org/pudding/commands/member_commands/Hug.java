package org.pudding.commands.member_commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Hug extends Command {
    public Hug() {
        super.name = "eatAss";
        super.cooldown = 5;
    }

    @Override
    protected void execute(CommandEvent e) {
        e.getMessage().getGuild().getMembers();
        if (!e.getArgs().isEmpty()) {
            if (!e.getMessage().getMentions().isEmpty()) {
                e.reply(e.getAuthor().getName() +  " has eaten " + e.getMessage().getMentionedUsers().get(0).getName() + "'s ass!");
            } else {
                e.reply("You didn't mention anyone!");
            }
        } else {
            e.reply("No arguments!");
        }
    }
}
