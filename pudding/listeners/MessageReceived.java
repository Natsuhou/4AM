package pudding.listeners;

import pudding.Utility.enums.PuddingTextChannels;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.Objects;

public class MessageReceived extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent e) {
        super.onGuildMessageReceived(e);

        if (PuddingTextChannels.getTextChannel(e.getChannel().getId()) != null) {
            switch (Objects.requireNonNull(PuddingTextChannels.getTextChannel(e.getChannel().getId()))) {
                case RULES:

                    break;
                case VERIFY:
                    break;
                case ROLES:
                    break;
                case FEMALE_SELFIES:
                    break;
                case NBNG_SELFIES:
                    break;
                case MALE_SELFIES:
                    break;
                case STAFF_QUEUE:
                    e.getMessage().addReaction("✔").queue();
                    break;
            }
        }
    }

}
