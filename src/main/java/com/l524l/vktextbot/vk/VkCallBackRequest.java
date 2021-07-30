package com.l524l.vktextbot.vk;

import com.google.gson.JsonObject;
import com.l524l.vktextbot.user.User;

public class VkCallBackRequest {
    private User requestSender;
    private JsonObject requestBody;

    public VkCallBackRequest(User requestUser, JsonObject requestBody) {
        this.requestSender = requestUser;
        this.requestBody = requestBody;
    }

    public User getRequestSender() {
        return requestSender;
    }

    public JsonObject getRequestBody() {
        return requestBody;
    }
}
