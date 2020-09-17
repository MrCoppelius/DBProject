package com.db.learn_english_bot.learn_english_bot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;

@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    String webHookPath;
    String botUserName;
    String botToken;

    @Bean
    LearnEnglishBot learnEnglishBot(){
        DefaultBotOptions defaultBotOptions = ApiContext.getInstance(DefaultBotOptions.class);
        LearnEnglishBot learnEnglishBot = new LearnEnglishBot(defaultBotOptions);
        learnEnglishBot.setBotToken(botToken);
        learnEnglishBot.setBotUserName(botUserName);
        learnEnglishBot.setWebHookPath(webHookPath);
        return learnEnglishBot;
    }
}
