package com.l524l.vktextbot;

import com.google.gson.JsonObject;
import com.l524l.vktextbot.handlers.RequestHandler;
import com.l524l.vktextbot.handlers.RequestHandlersChainBuilder;
import com.l524l.vktextbot.handlers.vk.BaseRequestHandler;
import com.l524l.vktextbot.handlers.vk.ConfirmationHandler;
import com.l524l.vktextbot.handlers.vk.SecretHandler;
import com.l524l.vktextbot.handlers.vk.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// FIXME: 27.08.2021 Перенести всю логику настройки конфигурации в другое место
@Controller
public class RequestReceiver {

    @Autowired
    private SecretHandler secretHandler;
    @Autowired
    private ConfirmationHandler confirmationHandler;
    @Autowired
    private BaseRequestHandler baseRequestHandler;
    @Autowired
    private UserHandler userHandler;
    @Autowired
    private RequestHandlersChainBuilder builder;


    @RequestMapping("/")
    public @ResponseBody
    String onVkCallBackReceived(@RequestBody JsonObject callBack) {

        builder.addHandler(baseRequestHandler);
        builder.addHandler(secretHandler);
        builder.addHandler(confirmationHandler);
        builder.addHandler(userHandler);

        RequestHandler handler = builder.buildChain();
        return handler.handleRequest(callBack);
    }
}