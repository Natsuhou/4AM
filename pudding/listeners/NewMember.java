package pudding.listeners;

import pudding.Utility.enums.PuddingRoles;
import pudding.Utility.enums.PuddingVoiceChannels;
import pudding.Utility.mongo.AccountHandling;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

//New member join event
public class NewMember extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent e) {
        if (!e.getMember().getUser().isFake() && !e.getMember().getUser().isBot()) {
            AccountHandling accountHandling = new AccountHandling(e.getUser());
            accountHandling.createAccount();

            //Set the account
            e.getGuild().getVoiceChannelsByName(PuddingVoiceChannels.MEMBER_COUNT.getVoiceChannelId(), false)
                    .get(0)
                    .getManager()
                    .setName(e.getGuild().getMembers().size() + " members")
                    .queue();
            
            //Give the user the temp role
            PuddingRoles.addRole(PuddingRoles.TEMP_MEMBER, e.getMember(), e.getGuild());

        } else {
            e.getMember().kick().queue();
        }
    }
}
