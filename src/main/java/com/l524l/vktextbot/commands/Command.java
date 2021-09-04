package com.l524l.vktextbot.commands;

import com.l524l.vktextbot.senders.DataSender;
import com.l524l.vktextbot.user.User;

import java.util.Map;

public abstract class Command {

    protected final User executor;
    private final Object additionalData;
    private final DataSender dataSender;

    public Command(User executor, Object additionalData, DataSender dataSender) {
        this.additionalData = additionalData;
        this.executor = executor;
        this.dataSender = dataSender;
    }

    protected abstract Map<String,String> getParams();

    public abstract void execute();
}
