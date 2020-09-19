package com.db.learn_english_bot.learn_english_bot.data;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.glassfish.grizzly.utils.Pair;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

@Data
public class DataModel {
    private long chatID;
    private long userID;
    private long count;
    private List<AbstractMap.SimpleEntry<String,String>> words = new ArrayList<>();

}
