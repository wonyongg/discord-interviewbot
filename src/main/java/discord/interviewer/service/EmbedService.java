package discord.interviewer.service;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
@RequiredArgsConstructor
public class EmbedService extends ListenerAdapter {
    @Autowired
    private final EmbedBuilder builder;

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        Guild guild = event.getGuild();
        TextChannel defaultChannel = (TextChannel) guild.getDefaultChannel();

        builder.setColor(Color.pink);
        builder.setAuthor("Github Repository Link", "https://github.com/wonyongg/discord-interviewbot");
        builder.setTitle("면접관 봇 V1.3.0");
        builder.setDescription("🤖 자바 & 스프링 기반 백엔드 엔지니어의 기술 면접을 도와주는 봇입니다.");
        builder.addBlankField(false);
        builder.addField("📌명령어 안내", "아래의 명령어를 입력하시면 명령어에 따른 면접 질문을 받을 수 있습니다.", false);
        builder.addBlankField(false);
        builder.addField("1️⃣전체 랜덤 질문", "👉🏻Q",true);
        builder.addField("2️⃣CS 질문", "👉🏻C",true);
        builder.addField("3️⃣자바 & 스프링 질문", "👉🏻J",true);
        builder.addBlankField(false);
        builder.addField("4️⃣네트워크 랜덤 질문", "👉🏻N",true);
        builder.addField("5️⃣운영체제 랜덤 질문", "👉🏻O",true);
        builder.addBlankField(false);
        builder.addField("6️⃣데이터베이스 랜덤 질문", "👉🏻D",true);
        builder.addField("7️⃣자료구조 랜덤 질문", "👉🏻A",true);
        builder.addBlankField(false);
        builder.addField("8️⃣기타 질문(DevOps, 디자인패턴 등)", "👉🏻E",true);
        builder.addField("9️⃣도움말", "👉🏻❕도움말",true);
        builder.addBlankField(false);
        builder.setFooter("📢오류 제보, 질문 추가 요청, 기타 건의 사항은 디스코드 DM으로 문의해주세요. -황원용-");

        MessageEmbed embed = builder.build();

        defaultChannel.sendMessageEmbeds(embed).queue();
    }
}