package Pudding.Utility.Profiles;

import Pudding.Utility.Enums.PuddingRanks;
import Pudding.Utility.Permissions.Pudding;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.awt.*;
import java.time.format.DateTimeFormatter;

public class Profile {
    private final EmbedBuilder embedBuilder;
    private final Member member;
    public Profile(Member m) {
        this.member = m;
        embedBuilder = new EmbedBuilder();
    }
    public EmbedBuilder getProfile() {
        EmbedBuilder profile = memberProfile();
        Pudding permissions = new Pudding(member);

        if (!permissions.isStaff()) {
            for (Role role : member.getRoles()) {
                switch (PuddingRanks.getRank(role.getId())) {
                    /****************************************
                     *             Donor Roles              *
                     ****************************************/
                    case PREMIUM_I:
                        break;
                    case PREMIUM_II:
                        break;
                    case PREMIUM_III:
                        break;
                    case PUDDING:
                        break;
                    /****************************************
                     *            Events Profiles           *
                     ****************************************/
                    //Crown role or top likes
                    default:
                        break;

                }
            }
        } else {
            //Put staff profile addon here
        }
        return profile;
    }
    //Basic Member Profile which can be added
    private EmbedBuilder memberProfile() {
        PuddingProfiles profiles = new PuddingProfiles(member.getUser());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currency = Integer.toString(profiles.getPoints());
        String likes = Integer.toString(profiles.getLikes());


        //embedBuilder.getFields().get(3).getValue().replace();
        return embedBuilder
                .setTitle(member.getUser().getName() + "'s Profile")
                .setColor(new Color(255, 183, 138))
                .setThumbnail(member.getUser().getAvatarUrl())
                .setDescription(profiles.getDescription())
                .setAuthor("\uD83C\uDF6E Admin")
                .addField("\uD83D\uDD14 DM status", "Ask", true)
                .addField("\uD83D\uDC96 Likes", likes, true)
                .addField("\uD83C\uDF6E Pudding", currency, true)
                .addField("#️⃣ Age", "over 18", true)
                .addField("✅ Verified", "test2", true)
                .addField("\uD83D\uDC91 Dating Status", "Test", true)
                .addField("\uD83D\uDD0E Searching For", "big tiddy goth gf", true)
                .addField("\uD83C\uDF86 Join Date ", member.getTimeJoined().format(dtf), true)
                .setFooter(member.getUser().getAsTag());
    }
    private EmbedBuilder premiumProfile() {
        return embedBuilder;
    }
    private EmbedBuilder staffAddon(String staffRank) {
        return embedBuilder;
    }
}
