package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.senders.vk.VkDataSender;
import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import com.vk.api.sdk.objects.messages.Message;

public class HelloVkCommand extends VkCommand {

    public HelloVkCommand(User executor, CallbackMessage<?> callbackMessage, VkDataSender dataSender) {
        super(executor, callbackMessage, dataSender);
    }

    @Override
    public void execute() {
        if (callbackMessage.getObject() instanceof Message) {
            Message message = (Message) callbackMessage.getObject();
            dataSender.sendMessage("hello", message.getPeerId());
            dataSender.sendMessage("hello", executor);
        }
    }
}
