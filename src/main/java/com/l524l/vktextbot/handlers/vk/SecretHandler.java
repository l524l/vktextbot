package com.l524l.vktextbot.handlers.vk;

import com.google.gson.JsonObject;
import com.l524l.vktextbot.handlers.RequestHandler;
import com.l524l.vktextbot.vk.GroupActorConfig;

public class SecretHandler extends RequestHandler {
    private GroupActorConfig config;

    public SecretHandler(GroupActorConfig config) {
        this.config = config;
    }

    @Override
    public String handleRequest(JsonObject object) {
        String requestSecret;
        String validSecret;
        if (object.has("secret")) {
            requestSecret = object.get("secret").getAsString();
            validSecret = config.getSecret();

            if (requestSecret.equals(validSecret))
                return handleByNextHandler(object);
        }
        return "ok";
    }
}
