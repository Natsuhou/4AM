import Pudding.Commands.Member_Commands.Hug;
import Pudding.Commands.Member_Commands.Voting.ChannelLimitVote;
import Pudding.Commands.Member_Commands.Voting.VoteKick;
import Pudding.EventListeners.OnMessageReceived;
import Pudding.Commands.Member_Commands.Verification;
import Pudding.Commands.Member_Commands.Test;
import Pudding.Commands.Staff_Commands.CreateAccount;
import Pudding.Commands.Staff_Commands.ClearChat;
import Pudding.Commands.Staff_Commands.Display.DisplayAnnouncements;
import Pudding.Commands.Staff_Commands.Display.DisplayLeaderboards;
import Pudding.Commands.Staff_Commands.Display.DisplayReactMenu;
import Pudding.Commands.Member_Commands.Profile.ChangeDescription;
import Pudding.Commands.Member_Commands.Profile.ChangeHobbies;
import Pudding.Commands.Member_Commands.Profile.DisplayProfile;
import Pudding.EventListeners.ReactionRemove;
import Pudding.EventListeners.ReactionAdd;
import Pudding.EventListeners.OnNewUserJoin;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Core extends ListenerAdapter implements Runnable {
    public static void main(String[] args) {
        try {
            final String token = "NjgyMTE1NTQ5OTgyODgzODUx.XlYUEg.vhaktfq7gIKU91gJirPdwYKUQiQ";

            EventWaiter waiter = new EventWaiter();
            CommandClientBuilder commandClientBuilder = new CommandClientBuilder()
                    .setOwnerId("381773847357161482")
                    .setPrefix("!")
                    .setActivity(Activity.watching("DEVELOPER BUILD"))
                    .addCommands(
                            //Staff commands
                            new CreateAccount(),
                            new DisplayProfile(),
                            new DisplayAnnouncements(),
                            new ClearChat(),
                            new DisplayLeaderboards(),
                            //Profile Commands
                            new ChangeDescription(),
                            new ChangeHobbies(),
                            new DisplayReactMenu(),
                            //User commands
                            new Verification(waiter),
                            new Test(),
                            new ChannelLimitVote(waiter),
                            new VoteKick(waiter),
                            new Hug()
                    );
            JDABuilder.createLight(token)
                    .addEventListeners(
                            commandClientBuilder.build(),
                            waiter,
                            new OnNewUserJoin(),
                            new ReactionAdd(),
                            new ReactionRemove(),
                            new OnMessageReceived())
                    .setStatus(OnlineStatus.ONLINE)
                    .build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void run() {

    }
}
