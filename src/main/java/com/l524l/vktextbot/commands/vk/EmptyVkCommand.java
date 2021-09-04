package com.l524l.vktextbot.commands.vk;

public class EmptyVkCommand extends VkCommand {

    public EmptyVkCommand() {
        super(null, null, null);
    }

    @Override
    public void execute() {
        System.out.println("Empty Vk command");
    }
}
