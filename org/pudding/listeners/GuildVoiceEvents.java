package org.pudding.listeners;

import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.guild.voice.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.pudding.utility.enums.PuddingVoiceChannels;

import javax.annotation.Nonnull;
import java.util.Objects;

public class GuildVoiceEvents extends ListenerAdapter {

    /*
        Join channel: onGuildVoiceJoin, onGuildVoiceMove
        GENERATE CHANNEL
        User moves channel/disconnects from channel
     */

    @Override
    public void onGuildVoiceUpdate(@Nonnull GuildVoiceUpdateEvent e) {
        if (Objects.nonNull(PuddingVoiceChannels.getChannel(e.getChannelJoined()))) {
            switch (Objects.requireNonNull(PuddingVoiceChannels.getChannel(e.getChannelJoined()))) {
                case GENERATE_3:
                    generateChannelAndMoveMember(e, 3);
                    break;
                case GENERATE_5:
                    generateChannelAndMoveMember(e,5);
                    break;
                case GENERATE_8:
                    generateChannelAndMoveMember(e,8);
                    break;
            }
        } else {
            for (VoiceChannel voiceChannel : e.getChannelJoined().getParent().getVoiceChannels()) {
                for (PuddingVoiceChannels puddingVoiceChannels : PuddingVoiceChannels.values()) {
                    if (!voiceChannel.getId().equals(puddingVoiceChannels.getId())) {
                        Objects.requireNonNull(e.getChannelLeft()).delete().queue();
                    }
                }
            }
        }
    }

    /*
    @Override
    public void onGuildVoiceJoin(@Nonnull GuildVoiceJoinEvent e) {
        if (Objects.nonNull(PuddingVoiceChannels.getChannel(e.getChannelJoined()))) {
            switch (PuddingVoiceChannels.getChannel(e.getChannelJoined())) {
                case GENERATE_3:
                    generateChannelAndMoveMember(e,3);
                    break;
                case GENERATE_5:
                    generateChannelAndMoveMember(e,5);
                    break;
                case GENERATE_8:
                    generateChannelAndMoveMember(e,8);
                    break;
            }
        }
    }

    @Override
    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent e) {
        if (Objects.nonNull(e.getChannelLeft())) {
            PuddingVoiceChannels thisPuddingChannel = PuddingVoiceChannels.getChannel(e.getChannelLeft());
            for (PuddingVoiceChannels pVoiceChannel : PuddingVoiceChannels.values()) {
                if (thisPuddingChannel != pVoiceChannel) {
                    e.getChannelLeft().delete().queue();
                    break;
                }
            }
        }
    }

    @Override
    public void onGuildVoiceMove(@Nonnull GuildVoiceMoveEvent e) {
        if (Objects.nonNull(PuddingVoiceChannels.getChannel(e.getChannelJoined()))) {
            switch (PuddingVoiceChannels.getChannel(e.getChannelJoined())) {
                case GENERATE_3:
                    generateChannelAndMoveMember(e,3);
                    break;
                case GENERATE_5:
                    generateChannelAndMoveMember(e,5);
                    break;
                case GENERATE_8:
                    generateChannelAndMoveMember(e,8);
                    break;
                default:
                    break;
            }
        } else {
            PuddingVoiceChannels thisPuddingChannel = PuddingVoiceChannels.getChannel(e.getChannelLeft());
            for (PuddingVoiceChannels pVoiceChannel : PuddingVoiceChannels.values()) {
                if (thisPuddingChannel == pVoiceChannel && Objects.nonNull(e.getChannelLeft())) {
                    e.getChannelJoined().delete().queue();
                    break;
                }
            }
        }
    }\

     */


    private void generateChannelAndMoveMember(GuildVoiceUpdateEvent e, int userLimit) {
        if (Objects.nonNull(e.getChannelJoined())) {
            e.getEntity().getGuild().createVoiceChannel(e.getEntity().getEffectiveName() + "'s channel")
                    .setParent(e.getChannelJoined().getParent())
                    .setUserlimit(userLimit)
                    .setPosition(e.getChannelJoined().getPosition())
                    .queue(voiceChannel ->
                            e.getEntity().getGuild().moveVoiceMember(e.getEntity(), voiceChannel).queue()
                    );
        }
    }
    private void generateChannelAndMoveMember(GuildVoiceMoveEvent e, int userLimit) {
        if (Objects.nonNull(e.getChannelJoined())) {
            e.getEntity().getGuild().createVoiceChannel(e.getEntity().getEffectiveName() + "'s channel")
                    .setParent(e.getChannelJoined().getParent())
                    .setUserlimit(userLimit)
                    .setPosition(e.getChannelJoined().getPosition())
                    .queue(voiceChannel ->
                            e.getEntity().getGuild().moveVoiceMember(e.getEntity(), voiceChannel).queue()
                    );
        }
    }
}
