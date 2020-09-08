package pudding.Utility.enums;

import net.dv8tion.jda.api.entities.Guild;
import org.jetbrains.annotations.Nullable;

public enum PuddingVoiceChannels {

    MEMBER_COUNT(null,"751070826039738439");

    private final String voiceChannelId;
    private final String voiceChannelName;

    PuddingVoiceChannels(String voiceChannelName, String voiceChannelId) {
        this.voiceChannelName = voiceChannelName;
        this.voiceChannelId = voiceChannelId;
    }

    public String getVoiceChannelName() {
        return voiceChannelName;
    }
    public String getVoiceChannelId() {
        return voiceChannelId;
    }

    public static @Nullable PuddingVoiceChannels getVoiceChannelbyId(String voiceChannelId) {
        for (PuddingVoiceChannels puddingVoiceChannels : PuddingVoiceChannels.values()) {
            if (puddingVoiceChannels != null) {
                if (puddingVoiceChannels.voiceChannelId.equals(voiceChannelId)) {
                    return puddingVoiceChannels;
                }
            }
        }
        return null;
    }
    public static void renameVoiceChannel(PuddingVoiceChannels puddingVoiceChannels, Guild guild, String newChannelName) {
        guild.getVoiceChannelsByName(puddingVoiceChannels.getVoiceChannelName(), false)
                .get(0)
                .getManager()
                .setName(newChannelName)
                .queue();
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
                        voiceChannels.add(guild.getVoiceChannelsByName(puddingVoiceChannels.getVoiceChannelName(), false).get(0));
                    }
                }
            }
        }
        return voiceChannels;
    }
    public static @NotNull VoiceChannel getVoiceChannel(Guild guild, PuddingVoiceChannels puddingVoiceChannels) {
        return guild.getVoiceChannelsByName(puddingVoiceChannels.getVoiceChannelName(), false).get(0);
    }

     */
}
