package pudding.commands.member_commands.Profile;

import pudding.Utility.profiles.PuddingProfiles;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class ChangeHobbies extends Command {
    public ChangeHobbies() {
        super.name = "ch";
        super.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
        PuddingProfiles puddingProfiles = new PuddingProfiles(e.getAuthor());

    }
}
