package Pudding.Utility.Menus;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class SupportUsMenu {
    private EmbedBuilder embedBuilder;
    public SupportUsMenu() {
        embedBuilder = new EmbedBuilder()
                .setColor(new Color(255, 100, 84))
                .setThumbnail("https://i.imgur.com/2DMx6H9.png")
                .setFooter("Please consider supporting the server!");
    }
    public EmbedBuilder serverBoostMenu() {
        return embedBuilder = new EmbedBuilder()
                .setTitle("\uD83D\uDD3C Boost Us Pls!")
                .setDescription("The server is owned and run by a small group of individuals that wanted to create a community "
                + "based upon NSFW/gaming/community type servers. Boosting helps (boost) our publicity and it gives us "
                + "a nice cover thingy which looks nice.");
    }
}
