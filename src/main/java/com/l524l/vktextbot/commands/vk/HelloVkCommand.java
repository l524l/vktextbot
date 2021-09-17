package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.commands.Command;
import com.l524l.vktextbot.vk.VkDataSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("HELLO_COMMAND")
@Scope(scopeName = "prototype")
public class HelloVkCommand extends Command {

    private final VkDataSender dataSender;

    @Autowired
    public HelloVkCommand(VkDataSender dataSender) {
        this.dataSender = dataSender;
    }

    @Override
    public void execute() {
        dataSender.sendMessage(String.format("Hello, %s!", executor.getFirstName()), executor);
    }
}
