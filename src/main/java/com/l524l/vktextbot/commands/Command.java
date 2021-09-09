package com.l524l.vktextbot.commands;

import com.l524l.vktextbot.vk.VkDataSender;
import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;

import java.util.Map;

public abstract class Command {

    protected final User executor;
    protected final CallbackMessage<?> callbackMessage;
    protected final VkDataSender dataSender;

    public Command(User executor, CallbackMessage<?> callbackMessage, VkDataSender dataSender) {
        this.callbackMessage = callbackMessage;
        this.executor = executor;
        this.dataSender = dataSender;
    }

    // FIXME: 04.09.2021 Доделать функционал
    protected Map<String, String> getParams() {
        throw new UnsupportedOperationException("unrealized functionality");
    }

    public abstract void execute();
}
