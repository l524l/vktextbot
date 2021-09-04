package com.l524l.vktextbot.commands.telegram;

public class EmptyTelegramCommand extends TelegramCommand {

    public EmptyTelegramCommand() {
        super(null, null, null);
    }

    @Override
    public void execute() {
        System.out.println("Empty Telegram command");
    }
}
