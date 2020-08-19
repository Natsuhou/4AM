package Pudding.Utility.Permissions;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.awt.*;

public class Pudding {
    private final Member member;
    private final EmbedBuilder embedBuilder;

    public Pudding(Member m) {
        member = m;
        embedBuilder = new EmbedBuilder()
                .setColor(new Color(255, 100, 84))
                .setTitle("Invalid permissions!")
                .setFooter("If you believe this is an error, contact staff!", "https://i.imgur.com/QDWW5Bq.png");
    }
    /********************************
        STAFF PERMISSION LEVELS
     ********************************/
    public boolean isFounder() {
        for (Role role : member.getRoles()) {
            if (role.getId().equals(PuddingPermissions.FOUNDER.getRankId())) {
                return true;
            }
        }
        return false;
    }
    public boolean isAdmin() {
        for (Role role : member.getRoles()) {
            if (role.getId().equals(PuddingPermissions.ADMIN.getRankId())) {
                return true;
            }
        }
        return false;
    }
    public boolean isMod() {
        for (Role role : member.getRoles()) {
            if (role.getId().equals(PuddingPermissions.MODERATOR.getRankId())) {
                return true;
            }
        }
        return false;
    }
    public boolean isHelper() {
        for (Role role : member.getRoles()) {
            if (role.getId().equals(PuddingPermissions.HELPER.getRankId())) {
                return true;
            }
        }
        return false;
    }
    public boolean isStaff() {
        return isFounder() || isAdmin() || isMod() || isHelper();
    }
    /********************************
        MEMBER PERMISSION LEVELS
     ********************************/
    public boolean member() {
        for (Role role : member.getRoles()) {
            if (role.getId().equals(PuddingPermissions.MEMBER.getRankId())) {
                return true;
            }
        }
        return false;
    }
    public EmbedBuilder notEnoughPermissions(PuddingPermissions rank) {
        switch (rank) {
            case FOUNDER:
                return embedBuilder.setDescription("Minimum required role: founder");
            case ADMIN:
                return embedBuilder.setDescription("Minimum required role: admin");
            case MODERATOR:
                return embedBuilder.setDescription("Minimum required role: mod");
            case HELPER:
                return embedBuilder.setDescription("Minimum required role: helper");
            default:
                return embedBuilder.setDescription("Invalid required role!");
        }
    }
}
