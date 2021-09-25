package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.annotations.SecureCommand;
import com.l524l.vktextbot.commands.Command;
import com.l524l.vktextbot.user.UserRole;
import com.l524l.vktextbot.vk.VkDataSender;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("SECRET_HELLO_COMMAND")
@Scope(scopeName = "prototype")
@SecureCommand(authorities = {UserRole.ADMIN, UserRole.OWNER})
public class SecuredHelloCommand extends Command {

    private final VkDataSender dataSender;

    public SecuredHelloCommand(VkDataSender dataSender) {
        this.dataSender = dataSender;
    }

    @Override
    public void execute() {
        dataSender.sendMessage(String.format("Здравствуйте, %s %s! Это совершенно секретно!", executor.getFirstName(),executor.getLastName()), executor);
    }
}
