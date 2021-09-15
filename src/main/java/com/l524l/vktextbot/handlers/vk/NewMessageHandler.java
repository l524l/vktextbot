package com.l524l.vktextbot.handlers.vk;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.l524l.vktextbot.database.UserRepository;
import com.l524l.vktextbot.exсeptions.UserLoadingException;
import com.l524l.vktextbot.exсeptions.vk.VkCallbackParsingException;
import com.l524l.vktextbot.handlers.RequestHandler;
import com.l524l.vktextbot.user.loaders.UserLoadProcessor;
import com.l524l.vktextbot.vk.VkDataSender;
import com.l524l.vktextbot.user.User;
import com.l524l.vktextbot.vk.*;
import com.vk.api.sdk.objects.callback.MessageType;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewMessageHandler extends RequestHandler implements VkCallBackSubject {

    private final UserLoadProcessor userLoadProcessor;
    private final List<VkCallBackObserver> observers;
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
                notifyCallBackObservers(requestSender, callbackMessage);

                return "ok";

            } else return handleByNextHandler(object);

        } catch (UserLoadingException | VkCallbackParsingException e) {
            return "ok";
        }
    }

    @Override
    public void registerCallBackObserver(VkCallBackObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeCallBackObserver(VkCallBackObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyCallBackObservers(User sender, CallbackMessage<?> request) {
        if (observers.isEmpty()) return;

        observers.forEach((x)-> x.update(sender, request));
    }
}
