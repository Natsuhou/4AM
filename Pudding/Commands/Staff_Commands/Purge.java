package pudding.commands.staff_commands;

import pudding.Utility.enums.PuddingRoles;
import pudding.Utility.permissions.Pudding;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Purge extends Command {
    public Purge() {
        super.name = "purge";
        super.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
        Pudding user = new Pudding(e.getMember());
        if (user.isStaff()) {

        } else {
            e.reply(user.notEnoughPermissions(PuddingRoles.HELPER).build());
        }
    }
}
