package discord.interviewer;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Service;

@Service
public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // 메시지 수신 이벤트 처리 테스트
        String[] args = event.getMessage().getContentRaw().split(" ");
        String prefix = "!";

        if (args[0].equalsIgnoreCase(prefix + "테스트"))
        event.getChannel().sendMessage("테스트입니다.").queue();
    }
}
