package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.commands.Command;
import com.l524l.vktextbot.commands.CommandFactory;
import com.l524l.vktextbot.commands.CommandType;
import com.l524l.vktextbot.vk.VkDataSender;
import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class VkCommandFactory extends CommandFactory {

    private final VkDataSender dataSender;

    @Autowired
    public VkCommandFactory(VkDataSender dataSender) {
        this.dataSender = dataSender;
    }

    @Override
    public Command createCommand(CommandType type, User executor, CallbackMessage<?> additionalData) {
        switch (type) {
            case EMPTY_COMMAND:
                return new EmptyVkCommand();
            case HELLO_COMMAND:
                return new HelloVkCommand(executor, additionalData, dataSender);
            default:
                return null;
        }
    }
}
