package org.pudding.random;

import net.dv8tion.jda.api.EmbedBuilder;


public class IntroductionMenu {
    private final EmbedBuilder embedBuilder;
    public IntroductionMenu() {
        embedBuilder = new EmbedBuilder()
                .setThumbnail("https://i.imgur.com/2DMx6H9.png");
    }

    public EmbedBuilder introductionMenu() {
        return embedBuilder
                .setTitle("Introduce Yourself")
                .setDescription("Give a short description about yourself! Here are some pointers for a possible description")
                .addField("• Age", "", false)
                .addField("• Hobbies", "", false)
                .addField("• Country", "", false)
                .addField("• Sexuality", "", false)
                .addField("• Gender", "", false)
                .addField("• Relationship Status", "", false)
                .addField("• Anything else", "", false)
                .setFooter("For the sake of everyone, please format in a readable manner!", null);
    }
}
