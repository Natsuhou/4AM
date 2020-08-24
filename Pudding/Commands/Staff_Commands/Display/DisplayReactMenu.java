package Pudding.Commands.Staff_Commands.Display;

import Pudding.Utility.Menus.ChannelMenus.ReactMenus;
import Pudding.Utility.Enums.PuddingRanks;
import Pudding.Utility.Permissions.Pudding;
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
                    ReactMenus reactMenu = new ReactMenus();
                    e.getChannel().sendMessage(reactMenu.ageMenu().build()).queue((message -> {
                        message.addReaction("\uD83D\uDD50").queue();
                        message.addReaction("\uD83D\uDD51").queue();
                        message.addReaction("\uD83D\uDD52").queue();
                        message.addReaction("\uD83D\uDD53").queue();
                        message.addReaction("\uD83D\uDD54").queue();
                    }));
                    break;
                case "dm":
                    ReactMenus reactMenu1 = new ReactMenus();
                    e.getChannel().sendMessage(reactMenu1.dmStatusMenu().build()).queue((message -> {

                    }));
                    break;
                case "lm":
                    ReactMenus reactMenu2 = new ReactMenus();
                    e.reply(reactMenu2.locationMenu().build());
                    break;
            }
        } else {
            e.reply(user.notEnoughPermissions(PuddingRanks.ADMIN).build());
        }
    }

}
