package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.annotations.BotCommand;
import com.l524l.vktextbot.commands.Command;
import com.l524l.vktextbot.vk.VkDataSender;
import org.springframework.beans.factory.annotation.Autowired;

@BotCommand("HELLO_COMMAND")
public class HelloVkCommand extends Command {

    private final VkDataSender dataSender;

    @Autowired
    public HelloVkCommand(VkDataSender dataSender) {
        this.dataSender = dataSender;
    }

    @Override
    public void execute() {
        dataSender.sendMessage(String.format("Привет, %s!", executor.getFirstName()), executor);
    }
}
