package Pudding.Commands.Staff_Commands;

import Pudding.Utility.Permissions.Pudding;
import Pudding.Utility.Permissions.PuddingPermissions;
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
            e.reply(user.notEnoughPermissions(PuddingPermissions.HELPER).build());
        }
    }
}
