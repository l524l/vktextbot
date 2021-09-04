package com.l524l.vktextbot;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.l524l.vktextbot.database.UserRepository;
import com.l524l.vktextbot.handlers.*;
import com.l524l.vktextbot.handlers.vk.BaseRequestHandler;
import com.l524l.vktextbot.handlers.vk.ConfirmationHandler;
import com.l524l.vktextbot.handlers.vk.SecretHandler;
import com.l524l.vktextbot.handlers.vk.UserHandler;
import com.l524l.vktextbot.vk.GroupActorConfig;
import com.l524l.vktextbot.senders.vk.VkDataSender;
import com.l524l.vktextbot.vk.VkCallbackParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// FIXME: 27.08.2021 Перенести всю логику настройки конфигурации в другое место
@Controller
public class RequestReceiver {

    @Autowired
    private GroupActorConfig actorConfig;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VkDataSender apiFacade;

    @RequestMapping("/")
    public @ResponseBody String onVkCallBackReceived(@RequestBody JsonObject callBack){
        BaseRequestHandler baseRequestHandler = new BaseRequestHandler();
        SecretHandler secretHandler = new SecretHandler(actorConfig);
        ConfirmationHandler confirmationHandler = new ConfirmationHandler(actorConfig);
        UserHandler userHandler = new UserHandler(userRepository, apiFacade, new VkCallbackParser(new Gson()));


        RequestHandlersChainBuilder builder = new RequestHandlersChainBuilder();
        builder.addHandler(baseRequestHandler);
        builder.addHandler(secretHandler);
        builder.addHandler(confirmationHandler);
        builder.addHandler(userHandler);

        RequestHandler handler = builder.buildChain();
        return handler.handleRequest(callBack);
    }
}
