package Pudding.Listeners;

import Pudding.Utility.Enums.PuddingChannels;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.Objects;

public class MessageReceived extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent e) {
        super.onGuildMessageReceived(e);

        switch (Objects.requireNonNull(PuddingChannels.getChannel(e.getChannel().getId()))) {
            case RULES:

                break;
            case VERIFY:
                System.out.println("verify");
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
            default:
                break;
        }


        /*
        if (e.getAuthor().isBot()) {
            StringBuilder rawContent = new StringBuilder();
            for (int i = 0; i < e.getMessage().getContentRaw().length(); i++) {
                char bruh = e.getMessage().getContentRaw().charAt(i);
                rawContent.append(bruh);
            }
            Message message = new MessageBuilder(rawContent).build();
            if (message.getContentRaw().contains("bruh")) {
                e.getChannel().sendMessage("bruh").queue();
            }


        }
         */
    }

}
