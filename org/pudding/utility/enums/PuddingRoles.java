package org.pudding.utility.enums;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public enum PuddingRoles {
    /***********************************
                STAFF ROLES
     **********************************/
    FOUNDER ("679056812229787699"),
    ADMIN ("626855987046776841"),
    MODERATOR ("627639688592883733"),
    HELPER ("627639889432936459"),
    /***********************************
                DONOR ROLES
     **********************************/
    VIP ("670375280686137373"),
    PUDDING ("741203611433959456"),
    PREMIUM_III ("741205623819206728"),
    PREMIUM_II ("630838747222638646"),
    PREMIUM_I ("741203629951942737"),
    /***********************************
                MEMBER ROLES
     **********************************/
    MEMBER ("627639516303327242"),
    VERIFIED ("627606457030017026"),
    TEMP_MEMBER ("677086321780588554"),
    WARNING("745421603319447583"),
    /***********************************
                REACT ROLES
     **********************************/
    DM_OPEN("677091454753046529"),
    DM_CLOSED("677091513540280340"),
    DM_ASK("677091780004675585"),
    MALE("743958190349221999"),
    FEMALE("754325772063342603"),
    TRANSGENDER("743958191083094017"),
    GENDERFLUID("754325773401194507"),
    OTHER_GENDER("754325773971882006");

    private final String rankId;

    PuddingRoles(String id) {
        this.rankId = id;
    }
    public String getRoleId() {
        return rankId;
    }
    public static @Nullable PuddingRoles getRole(Role role) {
        for (PuddingRoles PuddingRoles : PuddingRoles.values()) {
            if (PuddingRoles != null && PuddingRoles.getRoleId().equals(role.getId())) {
                return PuddingRoles;
            }
        }
        return null;
    }
    public static List<PuddingRoles> getRoles(List<Role> roles) {
        List<PuddingRoles> PuddingRolesList = new ArrayList<>();
        for (PuddingRoles puddingPuddingRoles : PuddingRoles.values()) {
            for (Role role : roles) {
                if (puddingPuddingRoles.getRoleId().equals(role.getId())) {
                    PuddingRolesList.add(puddingPuddingRoles);
                }
            }
        }
        return PuddingRolesList;
    }
    public static boolean hasRole(List<Role> roles, PuddingRoles @NotNull ... puddingRoles) {
        for (PuddingRoles puddingRole : puddingRoles) {
            for (Role role : roles) {
                if (role.getId().equals(puddingRole.getRoleId())) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void addRoles(Member member, PuddingRoles... roles) {
        for (PuddingRoles puddingRole : roles) {
            if (member.getGuild().getRoleById(puddingRole.getRoleId()) != null) {
                member.getGuild().addRoleToMember(
                        member.getId(),
                        member.getGuild().getRoleById(puddingRole.getRoleId())
                ).queue();
            }
        }
    }
    public static void removeRoles(Member member, PuddingRoles @NotNull ... roles) {
        for (PuddingRoles puddingRole : roles) {
            if (member.getGuild().getRoleById(puddingRole.getRoleId()) != null) {
                member.getGuild().removeRoleFromMember(member.getId(), Objects.requireNonNull(member.getGuild().getRoleById(puddingRole.getRoleId()))).queue();
            }
        }
    }
    public static boolean isStaff(@NotNull Member member) {
        return hasRole(member.getRoles(), PuddingRoles.FOUNDER, PuddingRoles.ADMIN, PuddingRoles.MODERATOR, PuddingRoles.HELPER);
    }
    public static boolean isVerified(@NotNull Member member) {
        for (Role role : member.getRoles()) {
            if (role.getId().equals(PuddingRoles.VERIFIED.getRoleId()) || isStaff(member)) {
                return true;
            }
        }
        return false;
    }
    public static EmbedBuilder notEnoughPermissions(PuddingRoles rank) {
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
