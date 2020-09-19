package com.db.learn_english_bot.learn_english_bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class LearnEnglishBot extends TelegramWebhookBot {
    String webHookPath;
    String botUserName;
    String botToken;
    @Autowired
    TelegramUpdateManager updateManager;
    public LearnEnglishBot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return updateManager.handleUpdate(update);
    }

    @Override
    public String getBotUsername() {
        return this.botUserName;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }

    @Override
    public String getBotPath() {
        return this.webHookPath;
    }

    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }

    public void setBotUserName(String botUserName) {
        this.botUserName = botUserName;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }
}
