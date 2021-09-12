package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.commands.Command;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class EmptyVkCommand extends Command {

    @Override
    public void execute() {
        System.out.println("Empty Vk command");
    }
}
