package org.pudding.commands.member_commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.concurrent.TimeUnit;

public class ChannelLimitVote extends Command {
    private final EventWaiter waiter;
    public ChannelLimitVote(EventWaiter w) {
        super.name = "clv";
        super.cooldown = 5;
        this.waiter = w;
    }

    @Override
    protected void execute(CommandEvent e) {

        final int[] bruh = {0};
        int dog;

        /*
        waiter.waitForEvent(GuildMessageReceivedEvent.class,
                event -> e.getAuthor().equals(event.getAuthor()) && e.getChannel().equals(event.getChannel()),
                event -> {
                    String name = "";

                    if (e.getMessage().getContentRaw().trim().length() > 10) {
                        e.getChannel().sendMessage(":x: | That name is too long!").queue();
                        //how do i go back to waiting for another message with the correct input?
                    } else {
                        //do something with the name
                    }
                    if (event.getMessage().getContentRaw().trim().length() > 10) {

                    } else if (e.getAuthor().equals(event.getAuthor())) {

                    }

                },
                2, TimeUnit.SECONDS, new Runnable() {
                    @Override
                    public void run() {
                        dog = 5;
                    }
                };

         */
    }
}
