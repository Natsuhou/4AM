package Pudding.Commands.Staff_Commands;

import Pudding.Utility.Permissions.Pudding;
import Pudding.Utility.Permissions.PuddingPermissions;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class HasAccount extends Command {
    public HasAccount() {
        super.name = "query";
        super.cooldown = 5;
    }

    @Override
    protected void execute(CommandEvent e) {
        Pudding permissions = new Pudding(e.getMember());
        if (permissions.isStaff()) {

        } else {
            e.reply(permissions.notEnoughPermissions(PuddingPermissions.HELPER).build());
        }
    }
}
