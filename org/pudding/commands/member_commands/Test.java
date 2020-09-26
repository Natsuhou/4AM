package org.pudding.commands.member_commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.pudding.utility.enums.PuddingVoiceChannels;

public class Test extends Command {
    public Test() {
        super.name = "testz";
        super.cooldown = 15;
    }

    @Override
    protected void execute(CommandEvent e) {
        PuddingVoiceChannels.renameVoiceChannel(PuddingVoiceChannels.MEMBER_COUNT, e.getGuild());
    }
}
