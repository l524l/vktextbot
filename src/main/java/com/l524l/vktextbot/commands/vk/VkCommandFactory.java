package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.commands.Command;
import com.l524l.vktextbot.commands.CommandFactory;
import com.l524l.vktextbot.commands.CommandType;
import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public final class VkCommandFactory extends CommandFactory {

    private final ApplicationContext applicationContext;

    @Autowired
    public VkCommandFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Command createCommand(CommandType type, User executor, CallbackMessage<?> additionalData) {
        Command command;
        switch (type) {
            case EMPTY_COMMAND:
                command = applicationContext.getBean(EmptyVkCommand.class);
                break;
            case HELLO_COMMAND:
                command = applicationContext.getBean(HelloVkCommand.class);
                break;
            default:
                return null;
        }
        command.setContext(executor, additionalData);
        return command;
    }
}
