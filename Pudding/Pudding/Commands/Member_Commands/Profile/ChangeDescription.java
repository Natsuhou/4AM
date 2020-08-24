package Pudding.Commands.Member_Commands.Profile;

import Pudding.Utility.Profiles.Profile;
import Pudding.Accounts.PuddingProfiles;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class ChangeDescription extends Command {
    public ChangeDescription() {
        super.name = "cd";
        super.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
        Profile profileMenu = new Profile(e.getMember());
        PuddingProfiles puddingProfiles = new PuddingProfiles(e.getAuthor());
        puddingProfiles.setDescription(e.getArgs());

        String successMessage = "Description has been successfully changed!";
        e.reply(profileMenu.getProfile().build());
    }
}
