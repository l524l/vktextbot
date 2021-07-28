package com.l524l.vktextbot.vk;

import com.google.gson.JsonObject;

public interface VkCallBackObserver {
    public void update(JsonObject object);
}
