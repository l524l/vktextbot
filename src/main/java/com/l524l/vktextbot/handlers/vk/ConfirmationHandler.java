package com.l524l.vktextbot.handlers.vk;

import com.google.gson.JsonObject;
import com.l524l.vktextbot.handlers.RequestHandler;
import com.l524l.vktextbot.vk.GroupActorConfig;

public class ConfirmationHandler extends RequestHandler {

    private GroupActorConfig actorConfig;

    public ConfirmationHandler(GroupActorConfig actorConfig) {
        this.actorConfig = actorConfig;
    }

    @Override
    public String handleRequest(JsonObject object) {
        String type = object.get("type").getAsString();

        if (type.equals("confirmation"))
            return actorConfig.getConfirmationToken();

        return handleByNextHandler(object);
    }
}
