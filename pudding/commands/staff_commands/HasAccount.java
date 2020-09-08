package pudding.commands.staff_commands;

import pudding.Utility.enums.PuddingRoles;
import pudding.Utility.permissions.Pudding;
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
            e.reply(permissions.notEnoughPermissions(PuddingRoles.HELPER).build());
        }
    }
}
