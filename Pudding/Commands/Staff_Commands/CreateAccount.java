package Pudding.Commands.Staff_Commands;

import Pudding.RandomShit.ErrorMenus;
import Pudding.Accounts.AccountHandling;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;

public class CreateAccount extends Command {
    public CreateAccount() {
        super.name = "cAccount";
        super.cooldown = 5;
        super.userPermissions = new Permission[] {Permission.ADMINISTRATOR};
    }
    @Override
    protected void execute(CommandEvent e) {
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            AccountHandling accountHandling = new AccountHandling(e.getAuthor());
            accountHandling.createAccount();
        } else {
            ErrorMenus errorMenus = new ErrorMenus();
            e.reply(errorMenus.invalidUser().build());
        }
    }
}
