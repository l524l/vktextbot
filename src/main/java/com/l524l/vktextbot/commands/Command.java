package com.l524l.vktextbot.commands;

import com.l524l.vktextbot.user.User;
import com.l524l.vktextbot.vk.VkDataSender;
import com.vk.api.sdk.objects.callback.MessageType;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import com.vk.api.sdk.objects.messages.Message;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Command {

    protected final User executor;
    protected final CallbackMessage<?> callbackMessage;
    protected final VkDataSender dataSender;

    public Command(User executor, CallbackMessage<?> callbackMessage, VkDataSender dataSender) {
        this.callbackMessage = callbackMessage;
        this.executor = executor;
        this.dataSender = dataSender;
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
