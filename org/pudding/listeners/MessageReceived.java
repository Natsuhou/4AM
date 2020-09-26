package org.pudding.listeners;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import org.pudding.utility.enums.PuddingRoles;
import org.pudding.utility.enums.PuddingTextChannels;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class MessageReceived extends ListenerAdapter {
    private GuildMessageReceivedEvent event;
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent e) {
        event = e;
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            if (PuddingTextChannels.getTextChannel(e.getChannel().getId()) != null) {
                switch (PuddingTextChannels.getTextChannel(event.getChannel().getId())) {
                    case SEND_SEFLIES:
                        sendSelfie();
                        break;
                }
            }
        }
    }
    private void sendSelfie() {
        event.getMessage().delete().queue();
        for (Role role : event.getMember().getRoles()) {
            if (!event.getMessage().getAttachments().isEmpty() && PuddingRoles.getRole(role) != null) {
                switch (PuddingRoles.getRole(role)) {
                    case MALE:
                        for (Message.Attachment attachment : event.getMessage().getAttachments()) {
                            MessageChannel messageChannel = event.getGuild().getTextChannelById(PuddingTextChannels.MALE_SELFIES.getTextChannelId());
                            if (messageChannel != null) {
                                messageChannel.sendMessage("[profile](https://discordapp.com/channels/626853629558521876/676108509120823326/749621117374693386)").queue();
                                messageChannel.sendMessage(attachment.getUrl()).queue();
                            }
                        }
                        break;
                    case FEMALE:
                        break;
                }
            }
        }
    }

}
