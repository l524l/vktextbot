package com.l524l.vktextbot.handlers.vk;

import com.google.gson.JsonObject;
import com.l524l.vktextbot.exсeptions.UserLoadingException;
import com.l524l.vktextbot.exсeptions.vk.VkCallbackParsingException;
import com.l524l.vktextbot.handlers.RequestHandler;
import com.l524l.vktextbot.observers.NewMessageObserver;
import com.l524l.vktextbot.observers.NewMessageSubject;
import com.l524l.vktextbot.user.User;
import com.l524l.vktextbot.user.loaders.UserLoadProcessor;
import com.l524l.vktextbot.vk.VkCallbackParser;
import com.vk.api.sdk.objects.callback.MessageType;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewMessageHandler extends RequestHandler implements NewMessageSubject {

    private final UserLoadProcessor userLoadProcessor;
    private final List<NewMessageObserver> observers;
    private final VkCallbackParser parser;

    @Autowired
    public NewMessageHandler(UserLoadProcessor userLoadProcessor, VkCallbackParser parser) {
        this.userLoadProcessor = userLoadProcessor;
        observers = new ArrayList<>();
        this.parser = parser;
    }

    @Override
    public String handleRequest(JsonObject object) {
        User requestSender;
        CallbackMessage<?> callbackMessage;

        try {
            callbackMessage = parser.parse(object);

            if (callbackMessage.getType() == MessageType.MESSAGE_NEW) {

                Message message = (Message) callbackMessage.getObject();

                int userId = message.getFromId();

                requestSender = userLoadProcessor.loadUser(userId);
                notifyObservers(requestSender, message);

                return "ok";

            } else return handleByNextHandler(object);

        } catch (UserLoadingException | VkCallbackParsingException e) {
            return "ok";
        }
    }

    @Override
    public void registerObserver(NewMessageObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(NewMessageObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(User sender, Message message) {
        if (observers.isEmpty()) return;

        observers.forEach((x)-> x.onNewMessage(sender, message));
    }
}
