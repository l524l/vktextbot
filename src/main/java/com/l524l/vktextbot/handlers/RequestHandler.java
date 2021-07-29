package com.l524l.vktextbot.handlers;

import com.google.gson.JsonObject;

public abstract class RequestHandler {
    private RequestHandler nextHandler;

    public abstract String handleRequest(JsonObject object);

    protected String handleByNextHandler(JsonObject object){
        if (nextHandler != null)
            return nextHandler.handleRequest(object);
        else
            return "ok";
    }

    public void setNextHandler(RequestHandler handler){
        nextHandler = handler;
    }
}
