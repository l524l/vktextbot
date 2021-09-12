package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.commands.Command;
import com.l524l.vktextbot.vk.VkDataSender;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class HelloVkCommand extends Command {

    private final VkDataSender dataSender;

    @Autowired
    public HelloVkCommand(VkDataSender dataSender) {
        this.dataSender = dataSender;
    }

    @Override
    public void execute() {
        if (callbackMessage.getObject() instanceof Message) {
            Message message = (Message) callbackMessage.getObject();
            dataSender.sendMessage("hello", message.getPeerId());
            dataSender.sendMessage("hello", executor);
        }
    }
}
