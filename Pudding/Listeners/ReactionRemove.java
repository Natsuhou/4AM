package Pudding.Listeners;

import Pudding.Utility.Profiles.PuddingProfiles;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ReactionRemove extends ListenerAdapter {
    @Override
    public void onGuildMessageReactionRemove(@Nonnull GuildMessageReactionRemoveEvent e) {
        super.onGuildMessageReactionRemove(e);

        switch (e.getChannel().getId()) {
            /*************************
             * RULES CHANNEL
             *************************/
            case "677085736624848899":
                switch (e.getMessageId()) {
                    //Message Ids
                    case "678109204661272588":
                        switch (e.getReactionEmote().getName()) {
                            case "✅":
                                break;
                        }
                }
                break;
            /*************************
             * LEADERBOARDS CHANNEL
             *************************/
            //Female-selfies
            case "627619138340257795":
                MessageChannel messageChannel = e.getJDA().getTextChannelById("627619138340257795");
                if (e.getReactionEmote().getName().equals("\uD83D\uDC96")) {
                    messageChannel.retrieveMessageById(e.getMessageId()).queue(message1 -> {
                        message1.retrieveReactionUsers("\uD83D\uDC96").limit(1).queue(reactionUsers -> {
                            for (User user : reactionUsers) {
                                try {
                                    if (!Objects.equals(e.getUser(), user)) {
                                        PuddingProfiles puddingProfiles = new PuddingProfiles(e.getUser());
                                        System.out.println("hi");
                                        puddingProfiles.removeLikes(1);
                                    }
                                } catch (IndexOutOfBoundsException exception) {
                                    exception.printStackTrace();
                                }
                            }
                        });
                    });
                }
                break;
        }
    }
}
