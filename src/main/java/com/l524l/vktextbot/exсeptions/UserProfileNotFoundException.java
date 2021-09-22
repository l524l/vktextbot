package com.l524l.vktextbot.exсeptions;

public class UserProfileNotFoundException extends BotException {

    public UserProfileNotFoundException() {
        super("User not found");
    }

    public UserProfileNotFoundException(String message) {
        super(message);
    }

}
