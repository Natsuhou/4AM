package Pudding.Commands.Staff_Commands.Display;

import Pudding.Utility.Menus.Announcements.ServerAnnouncements;
import Pudding.Utility.Permissions.Pudding;
import Pudding.Utility.Permissions.PuddingPermissions;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;


public class DisplayAnnouncements extends Command {
    public DisplayAnnouncements() {
        super.name = "announce";
        super.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
        Pudding user = new Pudding(e.getMember());
        if (user.isFounder() || user.isAdmin()) {
            ServerAnnouncements announcementsMenu = new ServerAnnouncements();
            e.reply(announcementsMenu.welcomeMenu().build());
        } else {
            e.reply(user.notEnoughPermissions(PuddingPermissions.ADMIN).build());
        }
    }
}
