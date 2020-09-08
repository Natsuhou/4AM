package pudding.commands.staff_commands.Display;

import pudding.Utility.enums.PuddingRoles;
import pudding.Utility.menus.Announcements.ServerAnnouncements;
import pudding.Utility.permissions.Pudding;
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
            e.reply(user.notEnoughPermissions(PuddingRoles.ADMIN).build());
        }
    }
}
