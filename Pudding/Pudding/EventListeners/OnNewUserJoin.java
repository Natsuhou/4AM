package Pudding.EventListeners;

import Pudding.Accounts.AccountHandling;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.Objects;

public class OnNewUserJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent e) {
        super.onGuildMemberJoin(e);
        AccountHandling accountHandling = new AccountHandling(e.getUser());
        System.out.println("works");
        e.getGuild().addRoleToMember(e.getMember(), Objects.requireNonNull(e.getGuild().getRoleById("677086321780588554"))).complete();

        if(!e.getMember().getUser().isFake() && !e.getMember().getUser().isBot()) {
            if (!accountHandling.hasAccount()) {
                accountHandling.createAccount();
            } else {
                System.out.println("User joined and has an account!");
            }
        }
    }
}
