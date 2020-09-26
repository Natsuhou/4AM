package org.pudding.utility.menus;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import org.pudding.utility.enums.PuddingEmotes;

import java.awt.*;

public class ReactRoles {
    private static EmbedBuilder embedBuilder = null;
    public ReactRoles() {
        embedBuilder = new EmbedBuilder()
                .setColor(new Color(255, 183, 138))
                .setThumbnail("https://i.imgur.com/2DMx6H9.png");
    }
    public static void sendGenderMenu(TextChannel textChannel) {
        if (textChannel != null) {
            embedBuilder
                    .setTitle(PuddingEmotes.MENU_GENDER.getEmoteId() + " Gender Menu")
                    .setDescription("Please select the gender that you identify with")
                    .addField("Male", PuddingEmotes.MALE.getEmoteId(), true)
                    .addField("Female", PuddingEmotes.FEMALE.getEmoteId(), true)
                    .addField("Non-binary", PuddingEmotes.NON_BINARY.getEmoteId(), true)
                    .addField("Genderfluid", PuddingEmotes.GENDERFLUID.getEmoteId(), true)
                    .addField("Transgender", PuddingEmotes.TRANSGENDER.getEmoteId(), true)
                    .addField("Other", PuddingEmotes.OTHER_GENDER.getEmoteId(), true);

            textChannel.sendMessage(embedBuilder.build()).queue(message -> {
                message.addReaction(PuddingEmotes.MALE.getEmoteId()).queue();
                message.addReaction(PuddingEmotes.FEMALE.getEmoteId()).queue();
                message.addReaction(PuddingEmotes.NON_BINARY.getEmoteId()).queue();
                message.addReaction(PuddingEmotes.GENDERFLUID.getEmoteId()).queue();
                message.addReaction(PuddingEmotes.TRANSGENDER.getEmoteId()).queue();
                message.addReaction(PuddingEmotes.OTHER_GENDER.getEmoteId()).queue();
            });
        }
    }
    public static void sendLocationMenu(TextChannel textChannel) {
        embedBuilder
                .setTitle("Location")
                .setDescription("Please select the region that relates to you")
                .addField("North America", ":flag_us:", false)
                .addField("South America", ":flag_br:", false)
                .addField("Europe", ":flag_eu:", false)
                .addField("Africa", ":flag_et:", false)
                .addField("Asia", ":flag_kr:", false)
                .addField("Middle East ", ":flag_sa:", false)
                .addField("Australia", ":flag_au:", false);
        textChannel.sendMessage(embedBuilder.build()).queue(message -> {

        });
    }
    public void sendEthnicityMenu() {
        embedBuilder
                .setTitle("Ethnicity")
                .setDescription("Please select the race you primarily identify with")
                .addField("White", ":blue_square:", false)
                .addField("Black", ":red_square:", false)
                .addField("Asian", ":brown_square:", false)
                .addField("European", ":green_square:", false);
    }
    public static void sendAgeMenu(TextChannel textChannel) {
        if (textChannel != null) {
            embedBuilder
                    .setTitle("\uD83D\uDD70 Age")
                    .setDescription("Please select your age range")
                    .addField("18-21", ":clock1:", false)
                    .addField("22-25", ":clock2:", false)
                    .addField("26-31", ":clock3:", false)
                    .addField("32+", ":clock4:", false);
            textChannel.sendMessage(embedBuilder.build()).queue(message -> {
                message.addReaction(PuddingEmotes.AGE_18_21.getEmoteId()).queue();
                message.addReaction(PuddingEmotes.AGE_22_26.getEmoteId()).queue();
                message.addReaction(PuddingEmotes.AGE_27_31.getEmoteId()).queue();
                message.addReaction(PuddingEmotes.AGE_32_PLUS.getEmoteId()).queue();
            });
        }
    }
    public static void sendDMStatusMenu(MessageChannel messageChannel) {
        if (messageChannel != null) {
            embedBuilder
                    .setTitle("Direct PuddingMessages")
                    .setDescription("Please select your DM preference")
                    .addField("Open DM", PuddingEmotes.OPEN_DM.getEmoteId(), true)
                    .addField("Closed DM", PuddingEmotes.CLOSED_DM.getEmoteId(), true)
                    .addField("Ask to DM", PuddingEmotes.ASK_TO_DM.getEmoteId(), true)
                    .setFooter("Please read these DM tags before DMing any member", null);
            messageChannel.sendMessage(embedBuilder.build()).queue(message -> {
                message.addReaction(PuddingEmotes.OPEN_DM.getEmoteId()).queue();
                message.addReaction(PuddingEmotes.CLOSED_DM.getEmoteId()).queue();
                message.addReaction(PuddingEmotes.ASK_TO_DM.getEmoteId()).queue();
            });
        }
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
}
