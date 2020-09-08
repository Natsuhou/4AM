package pudding.listeners;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import pudding.Utility.enums.PuddingMessages;
import pudding.Utility.enums.PuddingTextChannels;
import pudding.Utility.profiles.PuddingProfiles;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ReactionRemove extends ListenerAdapter {
    @Override
    public void onGuildMessageReactionRemove(@Nonnull GuildMessageReactionRemoveEvent e) {
        if (!e.getUser().isFake() && !e.getUser().isFake()) {
            switch (Objects.requireNonNull(PuddingTextChannels.getTextChannel(e.getChannel().getId()))) {
                case RULES:
                    //Message Id

                    break;
                case ROLES:
                    switch (Objects.requireNonNull(PuddingMessages.getMessage(e.getMessageId()))) {
                        case DM:
                        case AGE:
                        case LOCATION:
                        case GENDER:
                        case ETHNICITY:
                        case DATING_STATUS:
                    }
                    break;
                //Female selfies
                case FEMALE_SELFIES:
                    //Add a feature here that adds 1 to database also needs to be removed in messageAction removed
                    MessageChannel messageChannel = e.getJDA().getTextChannelById("627619138340257795");

                    if (e.getReactionEmote().getName().equals("\uD83D\uDC96")) {
                        assert messageChannel != null;
                        messageChannel.retrieveMessageById(e.getMessageId()).queue(message1 -> {
                            message1.retrieveReactionUsers("\uD83D\uDC96").limit(1).queue(users -> {
                                User bruh = null;
                                for (User user : users) {
                                    if (user.getId().equals(e.getUserId())) {
                                        bruh = user;
                                    }
                                }
                                PuddingProfiles puddingProfiles = new PuddingProfiles(e.getUser());
                                if (e.getMember().getUser() != bruh) {
                                    puddingProfiles.addLikes(1);
                                }
                            });
                        });
                    }
                    break;
            }
        }
    }
}
