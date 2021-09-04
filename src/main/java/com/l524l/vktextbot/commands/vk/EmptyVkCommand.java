package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;

public class EmptyVkCommand extends VkCommand {

    public EmptyVkCommand(User executor, CallbackMessage<?> callbackMessage) {
        super(executor, callbackMessage);
    }

    @Override
    public void execute() {
        System.out.println("Empty Vk command");
    }
}
