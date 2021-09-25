package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.commands.CommandType;
import com.l524l.vktextbot.user.User;
import com.l524l.vktextbot.user.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class VkCommandFactoryTest {

    @Autowired
    private VkCommandFactory vkCommandFactory;
    @Autowired
    private HelloVkCommand helloVkCommand;


    @Test
    void createCommand() {
        EmptyVkCommand helloVkCommand = (EmptyVkCommand) vkCommandFactory.createCommand(CommandType.EMPTY_COMMAND);
        helloVkCommand.execute();
    }
    @Test
    void executeTest() {
        User user = User.createNewDefaultUser(0,"as","as");
        //user.addRole(UserRole.ADMIN);
        helloVkCommand.setContext(user,null);
        helloVkCommand.execute();
    }
}