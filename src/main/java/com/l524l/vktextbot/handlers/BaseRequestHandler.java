package com.l524l.vktextbot.handlers;

import com.google.gson.JsonObject;

public class BaseRequestHandler extends RequestHandler {

    @Override
    public String handleRequest(JsonObject object) {
        return handleByNextHandler(object);
    }
}
