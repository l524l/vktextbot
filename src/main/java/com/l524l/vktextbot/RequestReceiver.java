package com.l524l.vktextbot;

import com.google.gson.JsonObject;
import com.l524l.vktextbot.handlers.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestReceiver {

    private final RequestHandler handler;

    @Autowired
    public RequestReceiver(@Qualifier("mainHandler") RequestHandler handler) {
        this.handler = handler;
    }

    @RequestMapping("/")
    public @ResponseBody
    String onVkCallBackReceived(@RequestBody JsonObject callBack) {
        return handler.handleRequest(callBack);
    }
}