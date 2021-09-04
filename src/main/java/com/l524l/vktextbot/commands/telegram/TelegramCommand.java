package com.l524l.vktextbot.commands.telegram;

import com.l524l.vktextbot.commands.Command;
import com.l524l.vktextbot.senders.telegram.TelegramDataSender;
import com.l524l.vktextbot.user.User;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

public abstract class TelegramCommand extends Command {

    protected final Update update;
    protected final TelegramDataSender dataSender;

    public TelegramCommand(User executor, Update update, TelegramDataSender dataSender) {
        super(executor, update, dataSender);
        this.update = update;
        this.dataSender = dataSender;
    }

    // FIXME: 04.09.2021 Доделать функционал
    @Override
    protected Map<String, String> getParams() {
        throw new UnsupportedOperationException("unrealized functionality");
    }
}
