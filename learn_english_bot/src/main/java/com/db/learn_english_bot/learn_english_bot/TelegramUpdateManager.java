package com.db.learn_english_bot.learn_english_bot;

import com.db.learn_english_bot.learn_english_bot.cache.ChatCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class TelegramUpdateManager {
    @Autowired
    ChatCache chatCache;
    @Autowired
    ResponseManager responseManager;


    public SendMessage handleUpdate(Update update) {
        SendMessage response = null;
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            response = handleInputMessage(message);
        }
        return response;


    }
    private SendMessage handleInputMessage(Message request) {
        BotStatus botStatus;
        String requestText = request.getText();
        SendMessage response;
        if (requestText.startsWith("/start")) {
            botStatus = BotStatus.RUN;
        }
        else if (requestText.startsWith("/help")) {
            botStatus = BotStatus.RUN;
        }
        else if (requestText.startsWith("/exit")) {
            botStatus = BotStatus.RUN;
        }
        else if(requestText.startsWith("/save_new_words)")){
            botStatus = BotStatus.SAVE_NEW_WORDS;
        }
        else if(requestText.startsWith("/get_new_words")){
            botStatus = BotStatus.GET_NEW_WORDS;
        }
        else if(requestText.startsWith("/get_saved_words")) {
            botStatus = BotStatus.GET_SAVED_WORDS;
        }
        else if(requestText.startsWith("/start_test"))
            botStatus = BotStatus.START_TEST_FOR_LEARNED_WORDS;
        else {
            botStatus = chatCache.getUserBotStatus(request.getChatId());
        }
        chatCache.setUserBotStatus(request.getChatId(),botStatus);
        response = responseManager.getResponse(request, botStatus);
        return  response;
    }


}