package com.l524l.vktextbot.handlers;

import com.google.gson.JsonObject;

public class BaseRequestHandler extends RequestHandler {

    public BaseRequestHandler(){

    }

    public BaseRequestHandler(RequestHandler nextHandler){
        setNextHandler(nextHandler);
    }


    @Override
    public String handleRequest(JsonObject object) {
        return handleByNextHandler(object);
    }
}
