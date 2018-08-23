package events;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import main.info;

public class online extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if(args[0].equalsIgnoreCase(info.prefix+"online"))
        {
            int o = 0;
            for (int i = 0; i < event.getGuild().getMembers().size() ; i++) {
                if(event.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.DO_NOT_DISTURB
                 || event.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.ONLINE
                || event.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.IDLE
                ||  event.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.INVISIBLE)
                {
                    o++;
                }

            }

            event.getChannel().sendMessage("There are "+o+" members online out of "+event.getGuild().getMembers().size() +" members in this server.").queue();
        }
    }

}