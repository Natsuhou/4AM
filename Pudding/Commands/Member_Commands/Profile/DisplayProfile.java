package Pudding.Commands.Member_Commands.Profile;

import Pudding.Utility.Profiles.Profile;
import Pudding.Utility.MongoAccounts.AccountHandling;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;

import java.awt.*;


public class DisplayProfile extends Command {
    public DisplayProfile() {
        super.name = "p";
        super.cooldown = 3;
    }

    @Override
    protected void execute(CommandEvent e) {
        if (!e.getArgs().isEmpty()) {
            if (!e.getMessage().getMentions().isEmpty()) {
                Member mentionedMember = e.getMessage().getMentionedMembers().get(0);
                Profile profile = new Profile(mentionedMember);
                AccountHandling accountHandling1 = new AccountHandling(mentionedMember.getUser());
                accountHandling1.createAccount();
                e.reply(profile.getProfile().build());
            } else {
                e.reply(invalidUser().build());
            }
        } else {
            AccountHandling accountHandling2 = new AccountHandling(e.getAuthor());
            accountHandling2.createAccount();
            Profile profile = new Profile(e.getMember());
            e.reply(profile.getProfile().build());
        }
    }
    private EmbedBuilder invalidUser() {
        return new EmbedBuilder()
                .setTitle(":x: Invalid User!")
                .setDescription("Please mention a user to check!")
                .setColor(new Color(255, 138, 138))
                .setFooter("Contact a staff member for further help!", "https://i.imgur.com/QDWW5Bq.png");
    }
}
