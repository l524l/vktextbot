package com.l524l.vktextbot.observers;

import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.messages.Message;

public interface NewMessageObserver {
    void onNewMessage(User user, Message message);
}
