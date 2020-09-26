package org.pudding.listeners;

import org.pudding.utility.enums.PuddingEmotes;
import org.pudding.utility.enums.PuddingRoles;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ReactionAdd extends ListenerAdapter {
    @Override
    public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent e) {
        if (!e.getUser().isBot()) {
            e.getReaction().removeReaction(e.getUser()).queue();
            switch (Objects.requireNonNull(PuddingEmotes.getEmote(e.getReactionEmote().getEmoji()))) {
                case RULES:
                    PuddingRoles.removeRoles(e.getMember(), PuddingRoles.TEMP_MEMBER);
                    PuddingRoles.addRoles(e.getMember(), PuddingRoles.MEMBER);
                    break;
                case OPEN_DM:
                    PuddingRoles.removeRoles(e.getMember(), PuddingRoles.DM_CLOSED, PuddingRoles.DM_ASK);
                    PuddingRoles.addRoles(e.getMember(), PuddingRoles.DM_OPEN);
                    break;
                case CLOSED_DM:
                    PuddingRoles.removeRoles(e.getMember(), PuddingRoles.DM_OPEN, PuddingRoles.DM_ASK);
                    PuddingRoles.addRoles(e.getMember(), PuddingRoles.DM_CLOSED);
                    break;
                case ASK_TO_DM:
                    PuddingRoles.removeRoles(e.getMember(), PuddingRoles.DM_OPEN, PuddingRoles.DM_CLOSED);
                    PuddingRoles.addRoles(e.getMember(), PuddingRoles.DM_ASK);
                case AGE_18_21:
                    PuddingRoles.removeRoles(e.getMember(), PuddingRoles.DM_OPEN, PuddingRoles.DM_CLOSED);
                    PuddingRoles.addRoles(e.getMember(), PuddingRoles.DM_ASK);
                    break;
                case AGE_22_26:
                    break;
                case AGE_27_31:
                    break;
                case AGE_32_PLUS:
                    break;
                default:
                    break;
            }
        }
    }
    /*
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
     */
}
