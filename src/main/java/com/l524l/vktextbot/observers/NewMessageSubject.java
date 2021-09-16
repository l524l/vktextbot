package com.l524l.vktextbot.observers;

import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.messages.Message;

public interface NewMessageSubject {
    void registerObserver(NewMessageObserver observer);
    void removeObserver(NewMessageObserver observer);
    void notifyObservers(User sender, Message message);
}
