package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.commands.Command;
import com.l524l.vktextbot.commands.CommandFactory;
import com.l524l.vktextbot.commands.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class VkCommandFactory extends CommandFactory {

    private final ApplicationContext applicationContext;

    @Autowired
    public VkCommandFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Command createCommand(CommandType type) {
        return (Command) applicationContext.getBean(type.name());
    }
}
