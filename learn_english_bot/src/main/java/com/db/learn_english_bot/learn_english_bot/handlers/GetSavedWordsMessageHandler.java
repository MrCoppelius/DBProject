package com.db.learn_english_bot.learn_english_bot.handlers;

import com.db.learn_english_bot.learn_english_bot.BotStatus;
import com.db.learn_english_bot.learn_english_bot.data.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Arrays;

@Component
public class GetSavedWordsMessageHandler implements MessageHandler {
    @Autowired
    RestTemplate restTemplate;
    @Value("${routerServiceURL}")
    String routerServiceURL;
    @Override
    public SendMessage menageMessage(Message message) {
        String str = message.getText().replaceAll("[^0-9]+", " ");
        int count = Integer.parseInt(Arrays.asList(str.trim().split(" ")).get(0));
        DataModel request = new DataModel();
        request.setChatID(message.getChatId());
        request.setCount(count);
        DataModel response = restTemplate.postForObject(routerServiceURL+"/get_saved_words", request, DataModel.class);
        return new SendMessage(response.getChatID(), response.getWords().toString());
    }

    @Override
    public BotStatus getServiceName() {
        return BotStatus.GET_SAVED_WORDS;
    }
}
