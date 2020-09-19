package com.db.learn_english_bot.learn_english_bot.data;

import lombok.Data;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

@Data
public class ChatSessionInfo {
    public List<AbstractMap.SimpleEntry<String,String>> worldsBuffer = new ArrayList<>();
    public int wordsCount;
}
