package org.pudding.random;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class VerificationMenu {
    private final EmbedBuilder embedBuilder;
    public VerificationMenu() {
        this.embedBuilder = new EmbedBuilder()
                .setColor(new Color(255, 183, 138))
                .setThumbnail("https://i.imgur.com/2DMx6H9.png");
    }
    public EmbedBuilder verifyMe() {
        return embedBuilder
                .setTitle(":white_check_mark:  Member Verification")
                .setDescription("18+ channels are locked by default members. Verifying yourself assures other "
                        + "members that they aren't interacting with an underage member/catfish. Plus, its very easy "
                        + "to do and you get access to 18+ channels!"
                )
                .addBlankField(false)
                .addField("\uD83C\uDFAB Image criteria",
                        "• Take a picture of yourself holding a piece of paper that has your discord id on it\n"
                                + "• The picture should be good quality and your face must be visible\n"
                                + "• Take another picture of your photo ID covering everything except your picture and "
                                + "date of birth\n"
                                + "• Verifying should be done individually", true)
                .addField("\uD83E\uDD14 Verification process",
                        "• Type !verify to begin verification\n"
                        + "• Send a picture containing the stuff specified above to the bot\n"
                        + "• Verification will typically take at least a day\n"
                        + "• Your verification is only available to administrators\n"
                        + "• If your pic looks sketchy we'll ask for additional evidence"
                        , true)
                .setFooter("Contact a staff member for further help!", "https://i.imgur.com/QDWW5Bq.png");
    }
}
