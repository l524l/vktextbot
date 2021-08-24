package com.l524l.vktextbot.exteptions;

public class BotException extends Exception {

    public BotException () {

    }

    public BotException (String message) {
        super(message);
    }

    public BotException (String message, Throwable throwable) {
        super(message, throwable);
    }

    public BotException (Throwable throwable) {
        super(throwable);
    }
}
