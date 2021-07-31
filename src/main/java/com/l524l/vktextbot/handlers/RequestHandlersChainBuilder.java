package com.l524l.vktextbot.handlers;

import java.util.ArrayList;
import java.util.List;

public class RequestHandlersChainBuilder {

    private List<RequestHandler> handlers;

    public RequestHandlersChainBuilder() {
        handlers = new ArrayList<>();
    }

    public RequestHandler buildChain() {
        for (int i = handlers.size()-1; i > 0 ; i--) {
            handlers.get(i-1).setNextHandler(handlers.get(i));
        }
        return handlers.get(0);
    }

    public void addHandler(RequestHandler handler) {
        handlers.add(handler);
    }

}
