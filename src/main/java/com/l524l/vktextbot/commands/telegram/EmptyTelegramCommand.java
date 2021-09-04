package com.l524l.vktextbot.commands.telegram;

import com.l524l.vktextbot.user.User;
import org.telegram.telegrambots.meta.api.objects.Update;

public class EmptyTelegramCommand extends TelegramCommand {

    public EmptyTelegramCommand(User executor, Update update) {
        super(executor, update);
    }

    @Override
    public void execute() {
        System.out.println("Empty Telegram command");
    }
}
