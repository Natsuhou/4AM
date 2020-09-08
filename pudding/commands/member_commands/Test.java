package pudding.commands.member_commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import pudding.Utility.permissions.Pudding;

public class Test extends Command {
    public Test() {
        super.name = "test";
    }

    @Override
    protected void execute(CommandEvent e) {
        Pudding pudding = new Pudding(e.getMember());
        if (pudding.isStaff()) {
            e.reply("you are gay");
        } else {
            e.reply("you are cringe");
        }
    }
}
