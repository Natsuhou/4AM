package Pudding.Commands.Staff_Commands;

import Pudding.Utility.Enums.PuddingRanks;
import Pudding.Utility.Permissions.Pudding;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Message;
import java.util.List;

public class ClearChat extends Command {
    public ClearChat() {
        super.name = "cc";
        super.cooldown = 2;
    }

    @Override
    protected void execute(CommandEvent e) {
        Pudding permissions = new Pudding(e.getMember());
        if (permissions.isStaff()) {
            try {
                int messageAmount = Integer.parseInt(e.getArgs());
                List<Message> messages = e.getTextChannel().getHistory().retrievePast(messageAmount).complete();

                for (int i = 0; i < messageAmount; i++) {
                    e.getTextChannel().deleteMessageById(messages.get(i).getId()).queue();
                }
            } catch (NumberFormatException exception) {
                e.reply("No specified args");
            }
        } else {
            e.reply(permissions.notEnoughPermissions(PuddingRanks.HELPER).build());
        }
    }
}
