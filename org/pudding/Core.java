package org.pudding;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import org.pudding.commands.member_commands.GetDiscordProfileIcon;
import org.pudding.commands.member_commands.Hug;
import org.pudding.commands.member_commands.ChannelLimitVote;
import org.pudding.commands.member_commands.VoteKick;
import org.pudding.commands.staff_commands.Ping;
import org.pudding.listeners.GuildVoiceEvents;
import org.pudding.listeners.MessageReceived;
import org.pudding.commands.member_commands.Verification;
import org.pudding.commands.member_commands.Test;
import org.pudding.commands.staff_commands.CreateAccount;
import org.pudding.commands.staff_commands.ClearChat;
import org.pudding.commands.staff_commands.DisplayLeaderboards;
import org.pudding.commands.member_commands.ChangeDescription;
import org.pudding.commands.member_commands.ChangeHobbies;
import org.pudding.commands.member_commands.DisplayProfile;
import org.pudding.listeners.ReactionRemove;
import org.pudding.listeners.ReactionAdd;
import org.pudding.listeners.MemberJoin;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.pudding.utility.enums.PuddingTextChannels;
import org.pudding.utility.menus.ReactRoles;

import javax.security.auth.login.LoginException;
import java.io.*;

public class Core extends ListenerAdapter {
    public static void main(String[] args) throws IOException {
        String path = "src/main/java/org/pudding/";
        String fileName = "uri.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./" + path + fileName));
        try {
            final String token = bufferedReader.readLine();
            EventWaiter waiter = new EventWaiter();
            CommandClientBuilder commandClientBuilder = new CommandClientBuilder()
                    .setOwnerId("381773847357161482")
                    .setPrefix("!")
                    .setActivity(Activity.watching("DEVELOPER BUILD"))
                    .addCommands(
                            //Staff Commands
                            new CreateAccount(),
                            new DisplayProfile(),
                            new ClearChat(),
                            new DisplayLeaderboards(),
                            new Ping(),
                            //Profile Commands
                            new ChangeDescription(),
                            new ChangeHobbies(),
                            //User Commands
                            new Verification(waiter),
                            new Test(),
                            new ChannelLimitVote(waiter),
                            new VoteKick(waiter),
                            new Hug(),
                            new GetDiscordProfileIcon()
                    );
            JDA jda = JDABuilder
                    .createDefault(
                            token,
                            GatewayIntent.GUILD_MESSAGES,
                            GatewayIntent.DIRECT_MESSAGES,
                            GatewayIntent.GUILD_VOICE_STATES,
                            GatewayIntent.GUILD_PRESENCES,
                            GatewayIntent.GUILD_MEMBERS,
                            GatewayIntent.GUILD_EMOJIS,
                            GatewayIntent.GUILD_MESSAGE_REACTIONS
                    )
                    .enableIntents(
                            GatewayIntent.GUILD_VOICE_STATES,
                            GatewayIntent.GUILD_MESSAGES,
                            GatewayIntent.DIRECT_MESSAGES,
                            GatewayIntent.GUILD_VOICE_STATES,
                            GatewayIntent.GUILD_PRESENCES,
                            GatewayIntent.GUILD_MEMBERS,
                            GatewayIntent.GUILD_EMOJIS,
                            GatewayIntent.GUILD_MESSAGE_REACTIONS
                    )
                    .addEventListeners(
                            commandClientBuilder.build(),
                            waiter,
                            new MemberJoin(),
                            new ReactionAdd(),
                            new ReactionRemove(),
                            new MessageReceived(),
                            new GuildVoiceEvents()
                    )
                    .setStatus(OnlineStatus.ONLINE)
                    .build()
                    .awaitReady();

            TextChannel rolesChannel = jda.getGuildById("626853629558521876").getTextChannelById(PuddingTextChannels.ROLES.getTextChannelId());
            class Menus {
                public void deleteMessages() {
                    for (Message message : rolesChannel.getHistory().getRetrievedHistory()) {
                        message.delete().queue();
                        System.out.println("bruh");
                    }
                }
                public void resendRolesMenu() {
                    ReactRoles.sendDMStatusMenu(rolesChannel);
                    ReactRoles.sendAgeMenu(rolesChannel);
                    ReactRoles.sendGenderMenu(rolesChannel);
                    ReactRoles.sendLocationMenu(rolesChannel);
                }
            }
        } catch (LoginException | InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }
}
