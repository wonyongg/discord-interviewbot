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
import java.util.stream.Collectors;

@Service
public class TextFileService extends ListenerAdapter {
    private final Random random = new Random();
    private final List<String> rawQuestions = new ArrayList<>();
    private final List<String> allQuestions;

    private final List<String> csQuestions;
    private final List<String> javaQuestions;
    private final List<String> etcQuestions;
    private final List<String> networkQuestions;
    private final List<String> OSQuestions;
    private final List<String> databaseQuestions;
    private final List<String> dataStructureQuestions;


    public TextFileService() throws IOException {
        this.rawQuestions.addAll(Files.readAllLines(Paths.get("src/main/resources/interview_questions.txt")));
        this.allQuestions = getQuestionsByTag("[");
        this.csQuestions = getQuestionsByTag("[cs]");
        this.javaQuestions = getQuestionsByTag("[언어 관련]");
        this.etcQuestions = getQuestionsByTag("[기타]");
        this.networkQuestions = getQuestionsByTag("[네트워크]");
        this.OSQuestions = getQuestionsByTag("[운영체제]");
        this.databaseQuestions = getQuestionsByTag("[데이터베이스]");
        this.dataStructureQuestions = getQuestionsByTag("[자료구조/알고리즘]");
    }

    private List<String> getQuestionsByTag(String tag) {
        return rawQuestions.stream()
                .filter(q -> q.contains(tag))
                .map(q -> q.split(":")[2])
                .collect(Collectors.toList());
    }

    private String getRandomQuestion(List<String> questions) {
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // 메시지 수신 이벤트 처리
        String[] args = event.getMessage().getContentRaw().split(" ");
        String prefix = "!";

        // 도움말 기능
        if (args[0].equalsIgnoreCase(prefix + "도움말") && !(event.getAuthor().isBot())) {
            event.getChannel().sendMessage("안녕하세요. 저는 면접관 봇입니다.\n\n" +
                                                   "명령어를 입력하여 저와 간단한 면접 연습을 진행하실 수 있습니다.").queue();
            event.getChannel().sendMessage("Q : 전체 랜덤 질문   C : CS 랜덤 질문").queue();
            event.getChannel().sendMessage("J : 자바 관련 랜덤 질문   E : 기타 랜덤 질문(DevOps, 디자인 패턴 등)").queue();
            event.getChannel().sendMessage("N : 네트워크 랜덤 질문   O : 운영체제 랜덤 질문").queue();
            event.getChannel().sendMessage("D : 데이터베이스 랜덤 질문   A : 자료구조 랜덤 질문").queue();
        }

        // 전체 질문
        if (args[0].equalsIgnoreCase("q") && !(event.getAuthor().isBot())) {
            sendMessage(event, allQuestions);
        }
        // CS 관련 질문
        if (args[0].equalsIgnoreCase("c") && !(event.getAuthor().isBot())) {
            sendMessage(event, csQuestions);
        }
        // 자바 관련 질문
        if (args[0].equalsIgnoreCase("j") && !(event.getAuthor().isBot())) {
            sendMessage(event, javaQuestions);
        }
        // 기타 질문
        if (args[0].equalsIgnoreCase("e") && !(event.getAuthor().isBot())) {
            sendMessage(event, etcQuestions);
        }
        // 네트워크 질문
        if (args[0].equalsIgnoreCase("n") && !(event.getAuthor().isBot())) {
            sendMessage(event, networkQuestions);
        }
        // 운영체제 질문
        if (args[0].equalsIgnoreCase("o") && !(event.getAuthor().isBot())) {
            sendMessage(event, OSQuestions);
        }
        // 데이터베이스 질문
        if (args[0].equalsIgnoreCase("d") && !(event.getAuthor().isBot())) {
            sendMessage(event, databaseQuestions);
        }
        // 자료구조 질문
        if (args[0].equalsIgnoreCase("a") && !(event.getAuthor().isBot())) {
            sendMessage(event, dataStructureQuestions);
        }
    }

    private void sendMessage(MessageReceivedEvent event, List<String> questions) {
        String randomQuestion = getRandomQuestion(questions);
        event.getChannel().sendMessage(randomQuestion).queue();
    }
}
