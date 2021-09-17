package com.l524l.vktextbot.commands;

import com.l524l.vktextbot.commands.vk.VkCommandFactory;
import com.l524l.vktextbot.observers.NewMessageObserver;
import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CommandQualifier implements NewMessageObserver {

    private final VkCommandFactory commandFactory;
    private final Pattern pattern;

    @Autowired
    public CommandQualifier(VkCommandFactory commandFactory) {
        this.commandFactory = commandFactory;
        pattern = Pattern.compile("(?<=^/)\\S+(?=\\s|$)");
    }

    @Override
    public void onNewMessage(User user, Message message) {
        CommandType type = parseCommandType(message.getText());

        Command command = commandFactory.createCommand(type);
        command.setContext(user, message);

        command.execute();
    }

    public CommandType parseCommandType(String string){
        String command = "";
        try {
            Matcher matcher = pattern.matcher(string);

            matcher.find();
            command = matcher.group();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommandType.getByCommandName(command);
    }
}
