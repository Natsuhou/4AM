package Pudding.EventListeners;

import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class OnMessageReceived extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent e) {
        super.onGuildMessageReceived(e);
        switch (e.getChannel().getId()) {
            //Verify queue for staff
            case "723001448153219114":
                e.getMessage().addReaction("✔").queue();
                e.getMessage().addReaction("❌").queue();
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
