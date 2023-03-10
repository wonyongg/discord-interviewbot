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
        builder.setTitle("λ©΄μ κ΄ λ΄ V1.2.1");
        builder.setDescription("π€ μλ° & μ€νλ§ κΈ°λ° λ°±μλ μμ§λμ΄μ κΈ°μ  λ©΄μ μ λμμ£Όλ λ΄μλλ€.");
        builder.addBlankField(false);
        builder.addField("πλͺλ Ήμ΄ μλ΄", "μλμ λͺλ Ήμ΄λ₯Ό μλ ₯νμλ©΄ λͺλ Ήμ΄μ λ°λ₯Έ λ©΄μ  μ§λ¬Έμ λ°μ μ μμ΅λλ€.", false);
        builder.addBlankField(false);
        builder.addField("1οΈβ£μ μ²΄ λλ€ μ§λ¬Έ", "ππ»Q",true);
        builder.addField("2οΈβ£CS μ§λ¬Έ", "ππ»C",true);
        builder.addField("3οΈβ£μλ° & μ€νλ§ μ§λ¬Έ", "ππ»J",true);
        builder.addBlankField(false);
        builder.addField("4οΈβ£κΈ°ν μ§λ¬Έ(DevOps, λμμΈν¨ν΄ λ±)", "ππ»E",true);
        builder.addField("5οΈβ£λμλ§", "ππ»βλμλ§",true);
        builder.addBlankField(false);
        builder.setFooter("π’μ€λ₯ μ λ³΄, μ§λ¬Έ μΆκ° μμ²­, κΈ°ν κ±΄μ μ¬ν­μ λμ€μ½λ DMμΌλ‘ λ¬Έμν΄μ£ΌμΈμ. -ν©μμ©-");

        MessageEmbed embed = builder.build();

        defaultChannel.sendMessageEmbeds(embed).queue();
    }
}