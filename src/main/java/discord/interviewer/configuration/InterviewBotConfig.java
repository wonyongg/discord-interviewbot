package discord.interviewer.configuration;

import javax.security.auth.login.LoginException;

import discord.interviewer.service.EmbedService;
import discord.interviewer.service.InterviewService;
import net.dv8tion.jda.api.EmbedBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.IOException;

@Configuration
public class InterviewBotConfig {
    @Value("${TOKEN}")
    private String discordToken;

    @Bean
    public EmbedBuilder embedBuilder() {
        return new EmbedBuilder();
    }

    @Bean
    public JDA jda() throws LoginException, IOException {
        JDA jda = JDABuilder.createDefault(discordToken)
                            .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES,
                                           GatewayIntent.GUILD_MESSAGE_REACTIONS,
                                           GatewayIntent.DIRECT_MESSAGE_REACTIONS, GatewayIntent.MESSAGE_CONTENT)
                            .build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("면접 준비"));
        jda.addEventListener(new InterviewService());
        jda.addEventListener(new EmbedService(embedBuilder()));
        return jda;
    }
}