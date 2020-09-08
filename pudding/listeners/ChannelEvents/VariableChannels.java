package pudding.listeners.ChannelEvents;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

/*
I would have a List<ChannelId> (max: 10).
Create a channel, add the id to the list. Listen for the Leave / Move event.
If empty: Delete channel and set the entry at the position of the list to null.
So next time you create a channel, get the first index of null to get the position.
So if X3 was deleted before, create X3 again. But then order gets completely messed up perhaps.
So a random name would be better so it doesn't look that confusing.
 */
public class VariableChannels extends ListenerAdapter {
    @Override
    public void onGuildVoiceJoin(@Nonnull GuildVoiceJoinEvent e) {
        super.onGuildVoiceJoin(e);
        if (e.getChannelJoined().getMembers().size() > 0) {
            //Generate new channel
        }
    }

    @Override
    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent e) {
        super.onGuildVoiceLeave(e);
        if (e.getChannelLeft().getMembers().size() < 1) {
            //Delete random
        }
    }

    @Override
    public void onGuildVoiceMove(@Nonnull GuildVoiceMoveEvent e) {
        super.onGuildVoiceMove(e);

        if (e.getChannelJoined().getMembers().size() > 0) {

        }

        if (e.getChannelLeft().getMembers().size() < 1) {

        }
    }

    private void generateVoiceChannel(Guild guild) {

    }
    private void removeGeneratedVoiceChannel(Guild guild) {

    }
    /*
    @Override
    public void onGuildVoiceJoin(@Nonnull GuildVoiceJoinEvent e) {
        super.onGuildVoiceJoin(e);
        switch (Objects.requireNonNull(PuddingVoiceChannels.getVoiceChannelbyName(e.getChannelJoined().getName()))) {
            case ROOM_1X:
                generateNewVoiceChannel(e, 3, PuddingVoiceChannels.ROOM_2X, PuddingVoiceChannels.ROOM_1X);
                break;
            case ROOM_2X:
                generateNewVoiceChannel(e, 3, PuddingVoiceChannels.ROOM_3X, PuddingVoiceChannels.ROOM_1X);
                break;
            case ROOM_1Y:
                generateNewVoiceChannel(e, 5, PuddingVoiceChannels.ROOM_2Y, PuddingVoiceChannels.ROOM_1Y);
                break;
            case ROOM_2Y:
                generateNewVoiceChannel(e, 5, PuddingVoiceChannels.ROOM_3Y, PuddingVoiceChannels.ROOM_1Y);
                break;
            case ROOM_1Z:
                generateNewVoiceChannel(e, 8, PuddingVoiceChannels.ROOM_2Z, PuddingVoiceChannels.ROOM_1Z);
                break;
            case ROOM_2Z:
                generateNewVoiceChannel(e, 8, PuddingVoiceChannels.ROOM_3Z, PuddingVoiceChannels.ROOM_1Z);
        }
    }

    @Override
    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent e) {
        super.onGuildVoiceLeave(e);
        if (PuddingVoiceChannels.getVoiceChannelbyName(e.getChannelLeft().getName()) != null) {
            switch (Objects.requireNonNull(PuddingVoiceChannels.getVoiceChannelbyName(e.getChannelLeft().getName()))) {
                case ROOM_2X:
                    removeChannel(e, PuddingVoiceChannels.ROOM_2X, PuddingVoiceChannels.ROOM_1X);
                    break;
                case ROOM_3X:
                    removeChannel(e, PuddingVoiceChannels.ROOM_3X, PuddingVoiceChannels.ROOM_2X);
                    break;
                case ROOM_2Y:
                    removeChannel(e, PuddingVoiceChannels.ROOM_2Y, PuddingVoiceChannels.ROOM_1Y);
                    break;
                case ROOM_3Y:
                    removeChannel(e, PuddingVoiceChannels.ROOM_3Y, PuddingVoiceChannels.ROOM_2Y);
                    break;
                case ROOM_2Z:
                    removeChannel(e, PuddingVoiceChannels.ROOM_2Z, PuddingVoiceChannels.ROOM_1Z);
                    break;
                case ROOM_3Z:
                    removeChannel(e, PuddingVoiceChannels.ROOM_3Z, PuddingVoiceChannels.ROOM_2Z);
                    break;
            }
        }
    }

    @Override
    public void onGuildVoiceMove(@Nonnull GuildVoiceMoveEvent e) {
        super.onGuildVoiceMove(e);

        switch (Objects.requireNonNull(PuddingVoiceChannels.getVoiceChannelbyName(e.getChannelJoined().getName()))) {
            case ROOM_1X:
                generateNewVoiceChannel(e, 3, PuddingVoiceChannels.ROOM_2X, PuddingVoiceChannels.ROOM_1X);
                break;
            case ROOM_2X:
                generateNewVoiceChannel(e, 3, PuddingVoiceChannels.ROOM_3X, PuddingVoiceChannels.ROOM_1X);
                break;
            case ROOM_1Y:
                generateNewVoiceChannel(e, 5, PuddingVoiceChannels.ROOM_2Y, PuddingVoiceChannels.ROOM_1Y);
                break;
            case ROOM_2Y:
                generateNewVoiceChannel(e, 5, PuddingVoiceChannels.ROOM_3Y, PuddingVoiceChannels.ROOM_1Y);
                break;
            case ROOM_1Z:
                generateNewVoiceChannel(e, 8, PuddingVoiceChannels.ROOM_2Z, PuddingVoiceChannels.ROOM_1Z);
                break;
            case ROOM_2Z:
                generateNewVoiceChannel(e, 8, PuddingVoiceChannels.ROOM_3Z, PuddingVoiceChannels.ROOM_1Z);
                break;
        }

        switch (Objects.requireNonNull(PuddingVoiceChannels.getVoiceChannelbyName(e.getChannelLeft().getName()))) {
            case ROOM_2X:
                removeChannel(e, PuddingVoiceChannels.ROOM_2X, PuddingVoiceChannels.ROOM_1X);
                break;
            case ROOM_3X:
                removeChannel(e, PuddingVoiceChannels.ROOM_3X, PuddingVoiceChannels.ROOM_2X);
                break;
            case ROOM_2Y:
                removeChannel(e, PuddingVoiceChannels.ROOM_2Y, PuddingVoiceChannels.ROOM_1Y);
                break;
            case ROOM_3Y:
                removeChannel(e, PuddingVoiceChannels.ROOM_3Y, PuddingVoiceChannels.ROOM_2Y);
                break;
            case ROOM_2Z:
                removeChannel(e, PuddingVoiceChannels.ROOM_2Z, PuddingVoiceChannels.ROOM_1Z);
                break;
            case ROOM_3Z:
                removeChannel(e, PuddingVoiceChannels.ROOM_3Z, PuddingVoiceChannels.ROOM_2Z);
                break;
        }
    }

    private void generateNewVoiceChannel(GuildVoiceJoinEvent e, int userLimit, PuddingVoiceChannels voiceChannel, PuddingVoiceChannels relativeVoiceChannel) {
        if (!hasDuplicateChannels(e.getGuild(), voiceChannel)) {
            if (e.getChannelJoined().getMembers().size() == 1) {
                Objects.requireNonNull(e.getGuild().getCategoryById(PuddingCategories.MAIN.getCategoryId()))
                        .createVoiceChannel(voiceChannel.getVoiceChannelName())
                        .setPosition(e.getGuild().getVoiceChannelsByName(relativeVoiceChannel.getVoiceChannelName(), false).get(0).getPosition()
                        ).setUserlimit(userLimit).queue();
            }
        } else {
            deleteDuplicateChannel(e.getGuild(), voiceChannel);
        }
    }

    private void generateNewVoiceChannel(GuildVoiceMoveEvent e, int userLimit, PuddingVoiceChannels voiceChannel, PuddingVoiceChannels relativeVoiceChannel) {
        if (!hasDuplicateChannels(e.getGuild(), voiceChannel)) {
            if (e.getChannelJoined().getMembers().size() == 1) {
                Objects.requireNonNull(e.getGuild().getCategoryById(PuddingCategories.MAIN.getCategoryId()))
                        .createVoiceChannel(voiceChannel.getVoiceChannelName())
                        .setPosition(e.getGuild().getVoiceChannelsByName(relativeVoiceChannel.getVoiceChannelName(), false).get(0).getPosition())
                        .setUserlimit(userLimit).queue();
            }
        } else {
            deleteDuplicateChannel(e.getGuild(), voiceChannel);
        }
    }
    private void removeChannel(GuildVoiceLeaveEvent e, PuddingVoiceChannels puddingVoiceChannels, PuddingVoiceChannels generatedVoiceChannel) {
        if (e.getChannelLeft().getMembers().size() == 0) {
            if (e.getGuild().getVoiceChannelsByName(generatedVoiceChannel.getVoiceChannelName(), false).get(0) == null) {
                e.getGuild().getVoiceChannelsByName(puddingVoiceChannels.getVoiceChannelName(), false);
                ChannelManager channelManager = new ChannelManagerImpl(e.getGuild().getVoiceChannelsByName(puddingVoiceChannels.getVoiceChannelName(), false)
                        .get(0));
                channelManager.setName(generatedVoiceChannel.getVoiceChannelName()).queue();
            } else {
                deleteDuplicateChannel(e.getGuild(), puddingVoiceChannels);
                e.getChannelLeft().delete().queue();
            }
        }
    }
    private void removeChannel(GuildVoiceMoveEvent e, PuddingVoiceChannels puddingVoiceChannels, PuddingVoiceChannels generatedVoiceChannel) {
        if (e.getChannelLeft().getMembers().size() == 0) {
            if (e.getGuild().getVoiceChannelsByName(generatedVoiceChannel.getVoiceChannelName(), false).get(0) == null) {
                e.getGuild().getVoiceChannelsByName(puddingVoiceChannels.getVoiceChannelName(), false);
                ChannelManager channelManager = new ChannelManagerImpl(e.getGuild().getVoiceChannelsByName(puddingVoiceChannels.getVoiceChannelName(), false)
                        .get(0));
                channelManager.setName(generatedVoiceChannel.getVoiceChannelName()).queue();
            } else {
                deleteDuplicateChannel(e.getGuild(), puddingVoiceChannels);
                e.getChannelLeft().delete().queue();
            }
        }
    }


    private void removeGeneratedChannel(Guild guild, PuddingVoiceChannels voiceChannels) {
        if (PuddingVoiceChannels.getVoiceChannel(guild, voiceChannels).getMembers().size() == 0) {
            PuddingVoiceChannels.getVoiceChannel(guild, voiceChannels).delete().queue();
        }
    }
    private boolean hasDuplicateChannels(Guild guild, PuddingVoiceChannels puddingVoiceChannels) {
        if (guild.getVoiceChannelsByName(puddingVoiceChannels.getVoiceChannelName(), false).size() > 1) {
            return true;
        }
        return false;
    }
    private void deleteDuplicateChannel(Guild guild, PuddingVoiceChannels puddingVoiceChannels) {
        if (guild.getVoiceChannelsByName(puddingVoiceChannels.getVoiceChannelName(), false).size() > 1) {
            for (VoiceChannel voiceChannel : guild.getVoiceChannelsByName(puddingVoiceChannels.getVoiceChannelName(), false)) {
                voiceChannel.delete().queue();
            }
        }
    }

     */
}
