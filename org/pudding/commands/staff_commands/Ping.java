package org.pudding.commands.staff_commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.pudding.utility.enums.PuddingRoles;

import java.util.concurrent.TimeUnit;

public class Ping extends Command {
    public Ping() {
        super.name = "ping";
        super.cooldown = 5;
    }

    @Override
    protected void execute(CommandEvent e) {
        e.getMessage().delete().queue();
        if (PuddingRoles.isStaff(e.getMember())) {
            e.getChannel().sendMessage("pong").queue(message -> {
                message.delete().queueAfter(5, TimeUnit.SECONDS);
            });
        } else {

        }
    }
}
