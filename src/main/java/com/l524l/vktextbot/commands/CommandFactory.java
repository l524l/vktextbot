package com.l524l.vktextbot.commands;

public abstract class CommandFactory {
    public abstract Command createCommand(CommandType type);
}
