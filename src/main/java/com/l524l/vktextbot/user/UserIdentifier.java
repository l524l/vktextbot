package com.l524l.vktextbot.user;

import com.google.gson.JsonObject;
import com.l524l.vktextbot.vk.VkCallBackObserver;
import com.l524l.vktextbot.vk.VkCallBackSubject;
import org.springframework.stereotype.Component;

@Component
public class UserIdentifier implements VkCallBackObserver {

    public UserIdentifier(VkCallBackSubject subject){
        subject.registerCallBackObserver(this);
    }

    @Override
    public void update(JsonObject object) {

    }
}
