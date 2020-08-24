package Pudding.Listeners;

import Pudding.Utility.MongoAccounts.AccountHandling;
import Pudding.Utility.Enums.PuddingRanks;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.Objects;

//New member join event
public class NewMember extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent e) {
        super.onGuildMemberJoin(e);

        if (!e.getMember().getUser().isFake() && !e.getMember().getUser().isBot()) {
            AccountHandling accountHandling = new AccountHandling(e.getUser());
            accountHandling.createAccount();

            //Give the user the temp role
            e.getGuild().addRoleToMember(
                    e.getMember(),
                    Objects.requireNonNull(
                            e.getGuild().getRoleById(PuddingRanks.TEMP_MEMBER.getRankId())
                    )
            ).complete();
        } else {
            e.getMember().kick().queue();
        }
    }
}
