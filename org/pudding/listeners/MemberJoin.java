package org.pudding.listeners;

import org.pudding.utility.enums.PuddingRoles;
import org.pudding.utility.enums.PuddingVoiceChannels;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class MemberJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent e) {
        if (!e.getMember().getUser().isFake() && !e.getMember().getUser().isBot()) {
            //Account handling needs to be fixed
            PuddingRoles.addRoles(e.getMember(), PuddingRoles.ADMIN);
            //Update the amount of players on the server
            PuddingVoiceChannels.renameVoiceChannel(PuddingVoiceChannels.MEMBER_COUNT, e.getGuild());

        } else {
            e.getMember().kick().queue();
        }
    }
}
