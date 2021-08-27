package com.l524l.vktextbot.vk;

import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;

public interface VkCallBackObserver {
    void update(User user, CallbackMessage<?> request);
}
