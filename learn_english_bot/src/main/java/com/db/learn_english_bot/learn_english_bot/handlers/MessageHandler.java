package com.db.learn_english_bot.learn_english_bot.handlers;

import com.db.learn_english_bot.learn_english_bot.BotStatus;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface MessageHandler {
    SendMessage menageMessage(Message message);
    BotStatus getServiceName();
}
