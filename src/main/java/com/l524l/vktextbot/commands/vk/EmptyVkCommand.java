package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.annotations.BotCommand;
import com.l524l.vktextbot.commands.Command;
import com.l524l.vktextbot.vk.VkDataSender;
import org.springframework.beans.factory.annotation.Autowired;

@BotCommand("EMPTY_COMMAND")
public class EmptyVkCommand extends Command {

    private final VkDataSender dataSender;

    @Autowired
    public EmptyVkCommand(VkDataSender dataSender) {
        this.dataSender = dataSender;
    }

    @Override
    public void execute() {
        dataSender.sendMessage("Команда не найдена!", executor);
    }
}
