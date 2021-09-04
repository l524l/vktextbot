package com.l524l.vktextbot.commands;

import com.l524l.vktextbot.user.User;

public abstract class CommandFactory<D> {
    public abstract Command createCommand(CommandType type, User executor, D additionalData);
}
