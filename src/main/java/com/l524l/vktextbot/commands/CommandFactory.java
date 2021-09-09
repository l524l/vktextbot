package com.l524l.vktextbot.commands;

import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;

public abstract class CommandFactory {
    public abstract Command createCommand(CommandType type, User executor, CallbackMessage<?> callbackMessage);
}
