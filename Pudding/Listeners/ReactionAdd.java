package Pudding.Listeners;

import Pudding.Utility.Profiles.PuddingProfiles;
import Pudding.Handle.ReactionOptions;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ReactionAdd extends ListenerAdapter {
    @Override
    public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent e) {
        super.onGuildMessageReactionAdd(e);

        if (!Objects.requireNonNull(e.getUser()).isBot() && !e.getUser().isFake()) {
            switch (e.getChannel().getId()) {
                //New member channel
                case "677085736624848899":
                    //Message Id
                    if (e.getMessageId().equals("678109204661272588")) {
                        switch (e.getReactionEmote().getName()) {
                            case "✅":
                                //Remove role: Temp member
                                e.getGuild().removeRoleFromMember(Objects.requireNonNull(e.getMember()), Objects.requireNonNull(e.getGuild().getRoleById("677086321780588554"))).complete();
                                //Add role: Member
                                e.getGuild().addRoleToMember(e.getMember(), Objects.requireNonNull(e.getGuild().getRoleById("627639516303327242"))).complete();
                                break;
                        }
                    }
                    break;
                //Roles Channels
                case "676708702874763274":
                    switch (e.getMessageId()) {
                        //Age Menu
                        case "682877788176515089":
                            switch (e.getReactionEmote().getName()) {
                                case "\uD83D\uDD50":
                                    String[] rolesId = {"676735227841871882", "676735243935547403", "676735257814499340", "676735283831767040", "676735302542557186"};
                                    String[] reactionsId = {"\uD83D\uDD51", "\uD83D\uDD52", "\uD83D\uDD53", "\uD83D\uDD54"};
                                    String addedRole = "676735227841871882";
                                    String messageId = "682877788176515089";
                                    ReactionOptions reactionOptions = new ReactionOptions(e.getGuild(), e.getChannel(), e.getMember());
                                    reactionOptions.handleOneRole(rolesId, reactionsId, addedRole, messageId);
                                case "\uD83D\uDD51":
                                    String[] rolesId2 = {"676735227841871882", "676735243935547403", "676735257814499340", "676735283831767040", "676735302542557186"};
                                    String[] reactionsId2 = {"\uD83D\uDD50", "\uD83D\uDD52", "\uD83D\uDD53", "\uD83D\uDD54"};
                                    String addedRole2 = "676735243935547403";
                                    String messageId2 = "682877788176515089";
                                    ReactionOptions reactionOptions2 = new ReactionOptions(e.getGuild(), e.getChannel(), e.getMember());
                                    reactionOptions2.handleOneRole(rolesId2, reactionsId2, addedRole2, messageId2);
                                case "\uD83D\uDD52":
                                case "\uD83D\uDD53":
                                case "\uD83D\uDD54":
                            }
                            break;
                        //Direct Message Menu
                        case "677091131124875277":
                            switch (e.getReactionEmote().getEmoji()) {

                            }
                            break;
                        //Location Menu
                        case "677393706667606038":
                            switch (e.getReactionEmote().getEmoji()) {

                            }
                            break;
                        //Gender Menu
                        case "6773eee706667606038":
                            switch (e.getReactionEmote().getEmoji()) {

                            }
                    }
                    break;
                //Female selfies
                case "627619138340257795":
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
