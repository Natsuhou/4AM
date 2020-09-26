package org.pudding.utility.enums;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.VoiceChannel;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public enum PuddingVoiceChannels {
    //Used for guild member count
    MEMBER_COUNT(null,"751070826039738439"),
    GENERAL(null, "757433687653613659"),
    KAROKE_ROOM(null, "630520101061263370"),
    //Generate channels
    GENERATE_3("Generate (3) ✨", "759284474902216713"),
    GENERATE_5("Generate (5) ✨", "759284492874809364"),
    GENERATE_8("Generate (8) ✨", "759284514240331796");

    private final String voiceChannelId;
    private final String voiceChannelName;

    PuddingVoiceChannels(@Nullable String voiceChannelName, String voiceChannelId) {
        this.voiceChannelName = voiceChannelName;
        this.voiceChannelId = voiceChannelId;
    }

    public String getName() {
        return voiceChannelName;
    }
    public String getId() {
        return voiceChannelId;
    }

    public static PuddingVoiceChannels getChannel(VoiceChannel voiceChannel) {
        for (PuddingVoiceChannels PuddingVoiceChannels : PuddingVoiceChannels.values()) {
            if (PuddingVoiceChannels.getId().equals(voiceChannel.getId())) {
                return PuddingVoiceChannels;
            }
        }
        return null;
    }
    public static void renameVoiceChannel(PuddingVoiceChannels voiceChannels, Guild guild) {
        Objects.requireNonNull(guild.getVoiceChannelById(voiceChannels.getId()))
                .getManager()
                .setName(guild.getMemberCount() + " members")
                .queue();
    }
    public static void generateVoiceChannel(Guild guild, String name, int userLimit) {
    }
    /*
    public static @NotNull List<PuddingVoiceChannels> getVoiceChannels(Guild guild) {
        List<PuddingVoiceChannels> voiceChannels = new ArrayList<>();

        for (PuddingVoiceChannels puddingVoiceChannelNames : PuddingVoiceChannels.values()) {
            for (VoiceChannel voiceChannel : guild.getVoiceChannels()) {
                if (voiceChannel == null) {
                    if (puddingVoiceChannelNames.voiceChannelName.equals(voiceChannel.getName())) {
                        voiceChannels.add(puddingVoiceChannelNames);
                    }
                }
            }
        }
        return voiceChannels;
    }
    *
     */
    /*
    public static @NotNull List<VoiceChannel> getVoiceChannels(Guild guild) {
        List<VoiceChannel> voiceChannels = new ArrayList<>();

        for (PuddingVoiceChannels puddingVoiceChannels : PuddingVoiceChannels.values()) {
            for (VoiceChannel voiceChannel : guild.getVoiceChannels()) {
                if (voiceChannel != null) {
                    if (puddingVoiceChannels.voiceChannelName.equals(voiceChannel.getName())) {
                        voiceChannels.add(guild.getVoiceChannelsByName(puddingVoiceChannels.getName(), false).get(0));
                    }
                }
            }
        }
        return voiceChannels;
    }
    public static @NotNull VoiceChannel getChannel(Guild guild, PuddingVoiceChannels puddingVoiceChannels) {
        return guild.getVoiceChannelsByName(puddingVoiceChannels.getName(), false).get(0);
    }

     */
}
