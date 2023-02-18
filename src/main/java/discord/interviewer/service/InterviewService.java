package discord.interviewer.service;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class InterviewService extends ListenerAdapter {
    private final Random random = new Random();
    private final List<String> questions = new ArrayList<>();


    public InterviewService() throws IOException {
        this.questions.addAll(Files.readAllLines(Paths.get("src/main/resources/interview_questions.txt")));
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // 메시지 수신 이벤트 처리
        String[] args = event.getMessage().getContentRaw().split(" ");
        String prefix = "!";

        // 도움말 기능
        if (args[0].equalsIgnoreCase(prefix + "도움말")) {
            event.getChannel().sendMessage("안녕하세요. 저는 면접관 봇입니다.\n\n" +
                                                   "\'!q\'를 통해 저와 간단한 면접 연습을 진행하실 수 있습니다.").queue();
        }

        // 면접 연습 기능
        if (args[0].equalsIgnoreCase(prefix + "q")) {
            int index = random.nextInt(questions.size());
            String[] rawQuestion = questions.get(index).split(":");
            String randomQuestion = rawQuestion[2];

            event.getChannel().sendMessage(randomQuestion).queue();


        }
    }
}
