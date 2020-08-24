package Pudding.Handle;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class ReactionOptions {
    private Guild guild;
    private MessageChannel channel;
    private Member member;
    public ReactionOptions(Guild g, MessageChannel c, Member m) {
        this.guild = g;
        this.channel = c;
        this.member = m;
    }
    public void handleOneRole(@NotNull String[] allRoles, String[] allReactions, String roleToAdd, String messageId) {
        for (String role : allRoles) {
            guild.removeRoleFromMember(member, Objects.requireNonNull(guild.getRoleById(role))).queue();
        }
        for (String reaction : allReactions)  {
            channel.retrieveMessageById(messageId).queue((message -> {
                message.removeReaction(reaction, member.getUser()).queue();
            }));
        }
        guild.addRoleToMember(member, Objects.requireNonNull(guild.getRoleById(roleToAdd))).queue();
    }
}
