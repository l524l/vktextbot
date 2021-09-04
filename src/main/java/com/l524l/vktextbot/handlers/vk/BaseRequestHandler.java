package com.l524l.vktextbot.handlers.vk;

import com.google.gson.JsonObject;
import com.l524l.vktextbot.handlers.RequestHandler;

public class BaseRequestHandler extends RequestHandler {

    @Override
    public String handleRequest(JsonObject object) {
        return handleByNextHandler(object);
    }
}
