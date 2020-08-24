package Pudding.Commands.Member_Commands;

import Pudding.Utility.Permissions.PuddingPermissions;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Test extends Command {
    public Test() {
        super.name = "test";
    }

    @Override
    protected void execute(CommandEvent e) {
        System.out.println(PuddingPermissions.ADMIN);
    }
}
