package org.pudding.commands.member_commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class ChangeDescription extends Command {
    public ChangeDescription() {
        super.name = "cd";
        super.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
    }
}
