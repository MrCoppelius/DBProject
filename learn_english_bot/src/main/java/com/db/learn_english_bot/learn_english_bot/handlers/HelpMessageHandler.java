package com.db.learn_english_bot.learn_english_bot.handlers;

import com.db.learn_english_bot.learn_english_bot.BotStatus;
import com.db.learn_english_bot.learn_english_bot.cache.ChatCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
@Component
public class HelpMessageHandler implements MessageHandler {
    @Autowired
    ChatCache chatCache;

    @Override
    public SendMessage menageMessage(Message message) {
        chatCache.cleanChatInfo(message.getChatId());
        return new SendMessage(message.getChatId(), "Hello!");
    }

    @Override
    public BotStatus getServiceName() {
        return BotStatus.RUN;
    }
}
