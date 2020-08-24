package Pudding.Accounts;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public class RoleHandler {
    private final Guild guild;
    private final Member member;
    public RoleHandler(Guild g, Member m) {
        this.guild = g;
        this.member = m;
    }
    public void removeMember() {
        for (Role role : member.getRoles()) {
            if (role != guild.getRoleById("670375280686137373")) {
                guild.removeRoleFromMember(member, guild.getRoleById("670375280686137373")).complete();
            }
        }
    }
    public void addMember() {
        for (Role role : member.getRoles()) {
            if (role != guild.getRoleById("670375280686137373")) {
                guild.removeRoleFromMember(member, guild.getRoleById("670375280686137373")).complete();
            }
        }
    }
}
