package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.commands.CommandType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VkCommandFactoryTest {

    @Autowired
    private VkCommandFactory vkCommandFactory;

    @Test
    void createCommand() {
        HelloVkCommand helloVkCommand = (HelloVkCommand) vkCommandFactory.createCommand(CommandType.HELLO_COMMAND, null, null);
    }
}