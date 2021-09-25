package com.l524l.vktextbot.commands;

import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.objects.messages.Message;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Command {

    protected User executor;
    protected Message message;

    public abstract void execute();

    public void setContext(User executor, Message message) {
        this.executor = executor;
        this.message = message;

    }

    public User getExecutor() {
        return executor;
    }

    public Message getMessage() {
        return message;
    }

    protected List<String> getParams() {
        String text = "";
        text = message.getText();
        text = text.replaceFirst("(^/\\S+(\\s+|$))", "");
        if (text.length() > 0) {
            return Arrays.asList(text.split("\\s+"));
        } else {
            return Collections.emptyList();
        }
    }


    
}
