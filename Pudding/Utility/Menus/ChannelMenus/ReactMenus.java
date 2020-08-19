package Pudding.Utility.Menus.ChannelMenus;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class ReactMenus {
    private final EmbedBuilder embedBuilder;
    public ReactMenus() {
        embedBuilder = new EmbedBuilder()
                .setColor(new Color(255, 183, 138))
                .setThumbnail("https://i.imgur.com/2DMx6H9.png");
    }
    public EmbedBuilder genderMenu() {
        return embedBuilder
                .setTitle("Gender Menu")
                .setDescription("Please select one gender that you primarily identify with")
                .addField("Male", ":male_sign:", true)
                .addField("Female", ":female_sign:", true)
                .addField("Not female not male", ":rainbow_flag:", true);
    }
    public EmbedBuilder locationMenu() {
        return embedBuilder
                .setTitle("Location Menu")
                .setDescription("Please select the region that relates to you")
                .addField("North America", ":flag_us:", false)
                .addField("South America", ":flag_br:", false)
                .addField("Europe", ":flag_eu:", false)
                .addField("Africa", ":flag_et:", false)
                .addField("Asia", ":flag_kr:", false)
                .addField("Middle East ", ":flag_sa:", false)
                .addField("Australia", ":flag_au:", false);
    }
    public EmbedBuilder raceMenu() {
        return embedBuilder
                .setTitle("Race Menu")
                .setDescription("Please select the race you primarily identify with")
                .addField("White", ":blue_square:", false)
                .addField("Black", ":red_square:", false)
                .addField("Asian", ":brown_square:", false)
                .addField("European", ":green_square:", false);
    }
    public EmbedBuilder ageMenu() {
        return embedBuilder
                .setTitle("Age Menu")
                .setDescription("Please select your age range")
                .addField("18+", ":clock1:", false)
                .addField("21+", ":clock2:", false)
                .addField("31+", ":clock3:", false)
                .addField("41+", ":clock4:", false)
                .addField("51+", ":clock5:", false);
    }
    public EmbedBuilder dmStatusMenu() {
        return embedBuilder
                .setTitle("Direct Message Menu")
                .setDescription("Please select your dm preference")
                .addField("Open DM", ":thumbsup:", true)
                .addField("Closed DM", ":thumbsdown:", true)
                .addField("Ask to DM", ":question:", true)
                .setFooter("Please read these DM tags before DMing any member", null);
    }
    public EmbedBuilder goalMenu() {
        return embedBuilder
                .setTitle("Goal Menu")
                .setDescription("What do you wanna achieve on this server?")
                .addField("Meet people", ":wave:", true)
                .addField("Game", ":video_game:", true)
                .addField("Find a relationship", ":heart:", true)
                .addField("Kinky shit", ":smiling_imp:", true)
                .addField("Server partner", ":handshake:", true)
                .addField("Something else", ":question:", true);
    }
    public EmbedBuilder relationshipMenu() {
        return embedBuilder
                .setTitle("Relationship Status Menu")
                .setDescription("Please select your relationship status")
                .addField("Single", ":man_raising_hand:", false)
                .addField("Taken", ":couple_with_heart:", false)
                .addField("Looking", ":person_gesturing_ok:", false)
                .addField("Not looking", ":person_gesturing_no:", false);
    }
    public EmbedBuilder gameMenu() {
        return embedBuilder
                .setTitle("Game Menu")
                .setDescription("We currently have support for the games below")
                .addField("\uD83C\uDF0D Minecraft", "", false);
    }
}
