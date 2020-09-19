package com.db.learn_english_bot.learn_english_bot.cache;

import com.db.learn_english_bot.learn_english_bot.BotStatus;
import com.db.learn_english_bot.learn_english_bot.data.ChatSessionInfo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ChatCache {
    Map<Long, BotStatus> userBotStatus = new HashMap<>();
    Map<Long, ChatSessionInfo> chatInfo = new HashMap<>();

    public void setUserBotStatus(Long chatID, BotStatus status) {
        this.userBotStatus.put(chatID, status);
    }

    public  BotStatus getUserBotStatus(Long chatID) {
        return userBotStatus.getOrDefault(chatID, BotStatus.RUN);
    }

    public void setChatInfo(Long chatID, ChatSessionInfo info) {
        this.chatInfo.put(chatID,info);
    }

    public ChatSessionInfo getChatInfo(Long chatID) {
        return chatInfo.getOrDefault(chatID, new ChatSessionInfo());
    }

    public void cleanChatInfo(Long chatID) {
        ChatSessionInfo info = getChatInfo(chatID);
        info.worldsBuffer.clear();
        info.wordsCount = 0;
        setChatInfo(chatID, info);
    }

}
