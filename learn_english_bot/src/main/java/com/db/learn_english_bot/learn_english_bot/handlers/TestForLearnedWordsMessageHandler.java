package com.db.learn_english_bot.learn_english_bot.handlers;

import com.db.learn_english_bot.learn_english_bot.BotStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
@Component
public class TestForLearnedWordsMessageHandler implements MessageHandler {
    @Override
    public SendMessage menageMessage(Message message) {
        return null;
    }

    @Override
    public BotStatus getServiceName() {
        return BotStatus.START_TEST_FOR_LEARNED_WORDS;
    }
}
