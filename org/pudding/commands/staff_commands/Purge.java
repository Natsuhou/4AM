package org.pudding.commands.staff_commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Purge extends Command {
    public Purge() {
        super.name = "purge";
        super.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {

    }
}
