package org.pudding.commands.member_commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

public class MemberHelp extends Command {
    public MemberHelp() {
        super.name = "mh";
        super.cooldown = 5;
    }

    @Override
    protected void execute(CommandEvent e) {

    }
    /*
    Potentially could add a system where each new command would register here.
    All new commands would be initialized

    At the moment it should all be done manually until server releases for simplicity sake
     */
    private EmbedBuilder mainMenu() {
        return new EmbedBuilder()
                .setTitle("\uD83D\uDCDD Server Menus")
                .setDescription("1. ");
    }
}
