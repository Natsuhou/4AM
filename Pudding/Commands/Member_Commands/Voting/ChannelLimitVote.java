package Pudding.Commands.Member_Commands.Voting;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;

public class ChannelLimitVote extends Command {
    private final EventWaiter waiter;
    public ChannelLimitVote(EventWaiter w) {
        super.name = "clv";
        super.cooldown = 5;
        this.waiter = w;
    }

    @Override
    protected void execute(CommandEvent e) {

    }
}
