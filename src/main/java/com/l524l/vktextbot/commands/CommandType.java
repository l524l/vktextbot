package com.l524l.vktextbot.commands;

public enum CommandType {
    EMPTY_COMMAND("empty"),
    HELLO_COMMAND("hello"),
    SECRET_HELLO_COMMAND("shello");

    private String commandName;

    CommandType(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public static CommandType getByCommandName(String commandName) {
        for (CommandType type:
             CommandType.values()) {
            if (type.getCommandName().equals(commandName)) return type;
        }
        return EMPTY_COMMAND;
    }
}
