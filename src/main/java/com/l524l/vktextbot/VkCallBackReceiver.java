package com.l524l.vktextbot;

import com.google.gson.JsonObject;
import com.l524l.vktextbot.handlers.BaseRequestHandler;
import com.l524l.vktextbot.handlers.ConfirmationHandler;
import com.l524l.vktextbot.handlers.SecretHandler;
import com.l524l.vktextbot.vk.GroupActorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VkCallBackReceiver {

    @Autowired
    private GroupActorConfig actorConfig;

    @RequestMapping("/")
    public @ResponseBody String onVkCallBackReceived(@RequestBody JsonObject callBack){
        BaseRequestHandler baseRequestHandler = new BaseRequestHandler(
                new ConfirmationHandler(
                        actorConfig,
                        new SecretHandler(actorConfig)
                )
        );
        String s = baseRequestHandler.handleRequest(callBack);
        return s;
    }
}
