package Pudding.Utility.Profiles;

import Pudding.Accounts.PuddingProfiles;
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
        embedBuilder = new EmbedBuilder()
                .setThumbnail("https://i.imgur.com/2DMx6H9.png");
    }
    public EmbedBuilder getProfile() {
        EmbedBuilder profile = memberProfile();
        Pudding permissions = new Pudding(member);

        if (!permissions.isStaff()) {
            for (Role role : member.getRoles()) {
                switch (role.getId()) {
                    /****************************************
                     *             Donor Roles              *
                     ****************************************/
                    //PuddingPermissions
                    case "3333":

                        break;
                    //Premium
                    case "12321333":

                        break;
                    //Cafe
                    case "1232133eee3":

                        break;
                    /****************************************
                     *            Events Profiles           *
                     ****************************************/
                    //Crown role or top likes
                    case "ttt":
                        break;
                        //Cafe
                    case "ee":
                        break;
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
                .setThumbnail(member.getUser().getAvatarUrl())
                .setColor(new Color(255, 183, 138))
                .setDescription(profiles.getDescription())
                .addField("\uD83D\uDC96 Likes ", likes, true)
                .addField("\uD83C\uDF6E PuddingPermissions ", currency, true)
                .addField("✅ Verified", "Not verified", true)
                .addField("\uD83D\uDD14 DM status", "Ask", true)
                .addField("\uD83C\uDF86 Join Date ", member.getUser().getTimeCreated().format(dtf), true)
                .setFooter(member.getUser().getAsTag());

    }
    private EmbedBuilder premiumProfile() {
        return embedBuilder;
    }
    private EmbedBuilder staffAddon(String staffRank) {
        return embedBuilder;
    }
}
