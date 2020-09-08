package pudding.Utility.menus.Announcements;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class VersionAnnouncements {
    private final EmbedBuilder embedBuilder;
    public VersionAnnouncements() {
        embedBuilder = new EmbedBuilder()
                .setColor(new Color(255, 100, 84))
                .setThumbnail("https://i.imgur.com/2DMx6H9.png")
                .setFooter("All updates will be posted in the changelog channel!", "https://i.imgur.com/QDWW5Bq.png");
    }
}
