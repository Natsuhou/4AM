package Pudding.Commands.Staff_Commands.Display;

import Pudding.Utility.Permissions.Pudding;
import Pudding.Utility.Enums.PuddingRanks;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

public class DisplayLeaderboards extends Command {
    public DisplayLeaderboards() {
        super.name = "displayBoard";
        super.cooldown = 5;
    }

    @Override
    protected void execute(CommandEvent e) {
        Pudding permissions = new Pudding(e.getMember());
        if (permissions.isStaff()) {
            e.reply(leaderBoard().build());
        } else {
            e.reply(permissions.notEnoughPermissions(PuddingRanks.ADMIN).build());
        }
    }
    private EmbedBuilder leaderBoard() {
        return new EmbedBuilder()
                .setTitle(" Global Leaderboard")
                .setDescription("This is the board for the likes")
                .addField("1. ", "Shogatsu", false)
                .addField("2. ", "Natsuhou", false)
                .addField("3. ", "Tree", false)
                .addField("4. ", "Dog", false)
                .addField("5. ", "Cat", false)
                .addField("6. ", "Bruh", false)
                .addField("7. ", "Okay", false)
                .addField("8. ", "Meme", false)
                .addField("9. ", "IPad", false)
                .addField("10. ", "Lol", false);
    }
}
