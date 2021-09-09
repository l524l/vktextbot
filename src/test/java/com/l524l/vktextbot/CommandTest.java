package com.l524l.vktextbot;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.l524l.vktextbot.commands.Command;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import com.vk.api.sdk.objects.messages.Message;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;

public class CommandTest extends Command {
    private static Gson gson = new Gson();
    private static Type typeToken = new TypeToken<CallbackMessage<Message>>(){}.getType();
    private static CallbackMessage callbackMessage = gson.fromJson("{\"type\": \"message_new\", \"object\" : { \"text\": \"/test   sa  as    ssas sa   \"}}",typeToken);

    public CommandTest() {
        super(null, callbackMessage, null);
    }

    @Override
    public void execute() {

    }

    @Test
    public void test() {
        System.out.println(getParams());
    }
}
