package com.l524l.vktextbot.exсeptions;

public class UserLoadingException extends BotException {

    public UserLoadingException() {
        super("User not found");
    }

    public UserLoadingException(String message) {
        super(message);
    }

}
