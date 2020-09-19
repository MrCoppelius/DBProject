package com.db.learn_english_bot.learn_english_bot;

import com.db.learn_english_bot.learn_english_bot.handlers.*;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ResponseManager {
    Map<BotStatus, MessageHandler> serviceHandler = new HashMap<>();
    ResponseManager(List<MessageHandler> serviceList) {
        serviceList.forEach(service -> serviceHandler.put(service.getServiceName(),service));
    }
    SendMessage getResponse(Message message, BotStatus status) {
        MessageHandler service = serviceHandler.get(status);
        return service.menageMessage(message);
    }
}
