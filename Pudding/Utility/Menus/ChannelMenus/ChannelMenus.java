package Pudding.Utility.Menus.ChannelMenus;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class ChannelMenus {
    private EmbedBuilder embedBuilder;
    public ChannelMenus() {
        this.embedBuilder = new EmbedBuilder()
                .setColor(new Color(255, 183, 138))
                .setThumbnail("https://i.imgur.com/2DMx6H9.png");
    }
    public EmbedBuilder serverRules() {
        return embedBuilder
                .setTitle(":page_with_curl: Server Guidelines Ver. 1.0")
                .setDescription(
                        "Failure to comply to any of these rules will result "
                        + "in a warning/punishment. "
                )
                .addBlankField(false)
                .addField("\t\uD83D\uDCF8 Posting/Chatting",
                        "• You are not allowed to post child pornography, death, violence, and other graphically disturbing images\n"
                                + "• Hateful speech and discrimination are prohibited. \n"
                                + "• All forms of harassment are prohibited."
                                + "• No catfishing, blackmailing, stalking, DDosing, doxxing scamming, bribing or any other related behavior.\n"
                                + "• Files and emojis containing nudity is allowed but should be used contextually."
                                + "\bfor instance: you dont pop a fat dick emoji in the league of legends channel", false
                )
                .addBlankField(false)
                .addField("\t:underage: Personal",
                        "• Minors (18 and under) are not allowed on the server.\n"
                                + "• Verify your identity in the verification tab to get access to the verified channels.\n"
                                + "• You are not allowed to have multiple accounts on the server.\n",false
                )
                .addBlankField(false)
                .addField("\t:handshake: Server Moderation",
                        "• All staff commands will be followed by members.\n"
                                + "• All basic server issues shall be answered by moderators.\n"
                                + "• If you believe a staff member is abusing look at their profile and report them.\n", false
                )
                .addField("\uD83D\uDCCC Leaderboards & Profiles",
                        "• Do not abuse the leaderboard/profile system.\n"
                                + "• Leaderboards will update on an hourly basis.\n"
                                + "• Profiles are used as another way for members to identify you. You are not required to make one but it is highly recommended\n", false
                )
                .addBlankField(false)
                .addField("\uD83D\uDCA1 Discord TOS",
                        "• Agree to follow Discord's terms of service\n"
                                + "• Discord TOS: https://discordapp.com/terms\n", false)
                .setFooter("By reacting with 'yes' to this post, you agree to follow the rules stated above.", "https://i.imgur.com/QDWW5Bq.png");
    }
}
