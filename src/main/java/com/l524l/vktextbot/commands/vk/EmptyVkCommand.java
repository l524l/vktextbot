package com.l524l.vktextbot.commands.vk;

import com.l524l.vktextbot.commands.Command;

public class EmptyVkCommand extends Command {

    public EmptyVkCommand() {
        super(null, null, null);
    }

    @Override
    public void execute() {
        System.out.println("Empty Vk command");
    }
}
