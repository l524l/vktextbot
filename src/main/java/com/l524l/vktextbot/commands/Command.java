package com.l524l.vktextbot.commands;

import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.callback.MessageType;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import com.vk.api.sdk.objects.messages.Message;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Command {

    protected User executor;
    protected CallbackMessage<?> callbackMessage;

    public void setContext(User executor, CallbackMessage<?> callbackMessage) {
        this.executor = executor;
        this.callbackMessage = callbackMessage;
    }

    protected List<String> getParams() {
        Message message;
        String text = "";
        if (callbackMessage.getType() == MessageType.MESSAGE_NEW) {
            message = (Message) callbackMessage.getObject();
            text = message.getText();
            text = text.replaceFirst("(^/\\S+(\\s+|$))", "");
        }
        if (text.length() > 0) {
            return Arrays.asList(text.split("\\s+"));
        } else {
            return Collections.emptyList();
        }
    }

    public abstract void execute();
    
}
