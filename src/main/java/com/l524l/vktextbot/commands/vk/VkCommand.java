package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.commands.Command;
import com.l524l.vktextbot.senders.vk.VkDataSender;
import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;

import java.util.Map;

public abstract class VkCommand extends Command {

    protected final CallbackMessage<?> callbackMessage;
    protected final VkDataSender dataSender;

    public VkCommand(User executor, CallbackMessage<?> callbackMessage, VkDataSender dataSender) {
        super(executor, callbackMessage, dataSender);
        this.callbackMessage = callbackMessage;
        this.dataSender = dataSender;
    }

    // FIXME: 04.09.2021 Доделать функционал
    @Override
    protected Map<String, String> getParams() {
        throw new UnsupportedOperationException("unrealized functionality");
    }
}
