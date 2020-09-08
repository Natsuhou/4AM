package pudding.Utility.permissions;

import pudding.Utility.enums.PuddingRoles;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.awt.*;

public class Pudding {
    private final Member member;

    public Pudding(Member m) {
        this.member = m;
    }
    /********************************
        STAFF PERMISSION LEVELS
     ********************************/
    public boolean isFounder() {
        for (Role role : member.getRoles()) {
            if (role.getId().equals(PuddingRoles.FOUNDER.getRankId())) {
                return true;
            }
        }
        return false;
    }
    public boolean isAdmin() {
        for (Role role : member.getRoles()) {
            if (role.getId().equals(PuddingRoles.ADMIN.getRankId())) {
                return true;
            }
        }
        return false;
    }
    public boolean isMod() {
        for (Role role : member.getRoles()) {
            if (role.getId().equals(PuddingRoles.MODERATOR.getRankId())) {
                return true;
            }
        }
        return false;
    }
    public boolean isHelper() {
        for (Role role : member.getRoles()) {
            if (role.getId().equals(PuddingRoles.HELPER.getRankId())) {
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
    public boolean isMember() {
        for (Role role : member.getRoles()) {
            if (role.getId().equals(PuddingRoles.MEMBER.getRankId())) {
                return true;
            }
        }
        return false;
    }
    public boolean isVerified() {
        for (Role role : member.getRoles()) {
            if (role.getId().equals(PuddingRoles.VERIFIED.getRankId()) || isStaff()) {
                return true;
            }
        }
        return false;
    }
    public EmbedBuilder notEnoughPermissions(PuddingRoles rank) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(new Color(255, 100, 84))
                .setTitle("Invalid permissions!")
                .setFooter("If you believe this is an error, contact staff!", "https://i.imgur.com/QDWW5Bq.png");
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