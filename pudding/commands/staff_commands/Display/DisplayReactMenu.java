package pudding.commands.staff_commands.Display;

import pudding.Utility.menus.ChannelMenus.RoleMenus;
import pudding.Utility.enums.PuddingRoles;
import pudding.Utility.permissions.Pudding;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class DisplayReactMenu extends Command {
    public DisplayReactMenu() {
        super.name = "dm";
        super.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
        Pudding user = new Pudding(e.getMember());
        if (user.isFounder() || user.isAdmin()) {
            switch (e.getArgs()) {
                //Age Menu
                case "am":
                    RoleMenus reactMenu = new RoleMenus();
                    e.getChannel().sendMessage(reactMenu.ageMenu().build()).queue((message -> {
                        message.addReaction("\uD83D\uDD50").queue();
                        message.addReaction("\uD83D\uDD51").queue();
                        message.addReaction("\uD83D\uDD52").queue();
                        message.addReaction("\uD83D\uDD53").queue();
                        message.addReaction("\uD83D\uDD54").queue();
                    }));
                    break;
                case "dm":
                    RoleMenus reactMenu1 = new RoleMenus();
                    e.getChannel().sendMessage(reactMenu1.dmStatusMenu().build()).queue((message -> {

                    }));
                    break;
                case "lm":
                    RoleMenus reactMenu2 = new RoleMenus();
                    break;
            }
        } else {
            e.reply(user.notEnoughPermissions(PuddingRoles.ADMIN).build());
        }
    }

}