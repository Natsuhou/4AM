package org.pudding.utility.menus;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class ServerAnnouncements {
        private EmbedBuilder embedBuilder;
        public ServerAnnouncements() {
            embedBuilder = new EmbedBuilder()
                    .setColor(new Color(255, 100, 84))
                    .setThumbnail("https://i.imgur.com/2DMx6H9.png")
                    .setFooter("All updates will be posted in the changelog channel!", "https://i.imgur.com/QDWW5Bq.png");
        }
        public EmbedBuilder welcomeMenu() {
            return embedBuilder
                    .setTitle("ServerAnnouncements to the PuddingRoles Server!")
                    .setDescription("This server is currently in development/testing phase but we hope you stick around anyway!")
                    .addField("\uD83D\uDD51 New Updates", "• We'll be adding new mechanics which will be posted in the changelog channel", false)
                    .addField("\uD83C\uDF89 Limited edition tag", "• All new members will be given a limited original org.pudding tag", false)
                    .addField("\uD83C\uDF6E Staff Information", "• We need staff right now so if you'd like to be part of the team, apply in the staff section!", false);
        }
    }
