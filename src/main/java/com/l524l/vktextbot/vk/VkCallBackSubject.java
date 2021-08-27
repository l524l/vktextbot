package com.l524l.vktextbot.vk;

import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;

public interface VkCallBackSubject {
    void registerCallBackObserver(VkCallBackObserver observer);
    void removeCallBackObserver(VkCallBackObserver observer);
    void notifyCallBackObservers(User sender, CallbackMessage<?> request);
}
