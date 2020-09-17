package com.db.learn_english_bot.learn_english_bot.controller;

import com.db.learn_english_bot.learn_english_bot.LearnEnglishBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebHookController {
    @Autowired
    private  LearnEnglishBot learnEnglishBot;
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return learnEnglishBot.onWebhookUpdateReceived(update);
    }

}
