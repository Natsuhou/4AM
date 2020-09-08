package pudding.RandomShit;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class ErrorMenus {
    private final EmbedBuilder embedBuilder;
    public ErrorMenus() {
        embedBuilder = new EmbedBuilder()
                .setColor(new Color(255, 100, 84))
                .setFooter("Contact a staff member for further help!", "https://i.imgur.com/QDWW5Bq.png");
    }
    public EmbedBuilder invalidUser() {
        return embedBuilder
                .setTitle(":x: Invalid User")
                .setDescription("User that issued command is either a bot or is fake.");
    }
    public EmbedBuilder invalidInput(String errorMessage) {
        return embedBuilder
                .setTitle(":x: Invalid Input")
                .setDescription(errorMessage);
    }
}
