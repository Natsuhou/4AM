package Pudding.Commands.Member_Commands.Voting;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;

public class VoteKick extends Command {
    private final EventWaiter waiter;
    public VoteKick(EventWaiter w) {
        super.name = "vk";
        super.cooldown = 50;
        this.waiter = w;
    }

    @Override
    protected void execute(CommandEvent e) {
        if (!e.getArgs().isEmpty()) {

        } else {

        }
    }
    private EmbedBuilder noArgs() {
        return new EmbedBuilder()
                .setTitle("No args");
    }
}
