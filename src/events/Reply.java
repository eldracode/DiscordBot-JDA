package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Reply extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if(args[0].equalsIgnoreCase("hey"))
        {
            if(!event.getMember().getUser().isBot())
            event.getChannel().sendMessage("hey " +event.getMember().getUser().getName()+" !").queue();
        }

    }
}
