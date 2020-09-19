package com.db.learn_english_bot.learn_english_bot.handlers;

import com.db.learn_english_bot.learn_english_bot.BotStatus;
import com.db.learn_english_bot.learn_english_bot.cache.ChatCache;
import com.db.learn_english_bot.learn_english_bot.data.ChatSessionInfo;
import com.db.learn_english_bot.learn_english_bot.data.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;

@Component
public class SaveNewWordsMessageHandler implements MessageHandler {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ChatCache chatCache;
    @Value("${routerServiceURL}")
    String routerServiceURL;

    @Override
    public SendMessage menageMessage(Message message) {
        DataModel request = new DataModel();
        DataModel response;
        ChatSessionInfo info = chatCache.getChatInfo(message.getChatId());
        if (info.worldsBuffer.isEmpty()) {
            String str = message.getText().replaceAll("[^0-9]+", " ");
            int count = Integer.parseInt(Arrays.asList(str.trim().split(" ")).get(0));
            info.setWordsCount(count);
        }
        else {
            List<String> pair = Arrays.asList(message.getText().trim().split(" "));
            AbstractMap.SimpleEntry<String,String> entry = new AbstractMap.SimpleEntry<>(pair.get(0), pair.get(1));
            info.worldsBuffer.add(entry);
            //todo
        }

    }

    @Override
    public BotStatus getServiceName() {
        return BotStatus.SAVE_NEW_WORDS;
    }
}
