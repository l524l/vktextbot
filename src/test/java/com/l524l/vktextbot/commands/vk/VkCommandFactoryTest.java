package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.commands.CommandType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class VkCommandFactoryTest {

    @Autowired
    private VkCommandFactory vkCommandFactory;

    @Test
    void createCommand() {
        EmptyVkCommand helloVkCommand = (EmptyVkCommand) vkCommandFactory.createCommand(CommandType.EMPTY_COMMAND, null, null);
        helloVkCommand.execute();
    }
}