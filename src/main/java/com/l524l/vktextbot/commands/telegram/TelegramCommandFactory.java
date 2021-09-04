package com.l524l.vktextbot.commands.telegram;

import com.l524l.vktextbot.commands.Command;
import com.l524l.vktextbot.commands.CommandFactory;
import com.l524l.vktextbot.commands.CommandType;
import com.l524l.vktextbot.senders.telegram.TelegramDataSender;
import com.l524l.vktextbot.user.User;
import org.telegram.telegrambots.meta.api.objects.Update;

public final class TelegramCommandFactory extends CommandFactory<Update> {

    private final TelegramDataSender dataSender;

    public TelegramCommandFactory(TelegramDataSender dataSender) {
        this.dataSender = dataSender;
    }

    @Override
    public Command createCommand(CommandType type, User executor, Update additionalData) {
        switch (type) {
            case EMPTY_COMMAND:
                return new EmptyTelegramCommand();
            default:
                return null;
        }
    }
}
