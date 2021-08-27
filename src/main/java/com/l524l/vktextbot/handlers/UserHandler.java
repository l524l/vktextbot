package com.l524l.vktextbot.handlers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.l524l.vktextbot.database.UserRepository;
import com.l524l.vktextbot.exteptions.VkCallbackParsingException;
import com.l524l.vktextbot.user.User;
import com.l524l.vktextbot.vk.*;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import com.vk.api.sdk.objects.messages.Message;

import java.util.ArrayList;
import java.util.List;

public class UserHandler extends RequestHandler implements VkCallBackSubject {

    private final UserRepository repository;
    private final VkApiFacade vkApiFacade;
    private final List<VkCallBackObserver> observers;
    private final VkCallbackParser parser;
    private final Gson gson;

    public UserHandler(UserRepository repository, VkApiFacade vkApiFacade, VkCallbackParser parser) {
        observers = new ArrayList<>();
        gson = new Gson();
        this.parser = parser;
        this.repository = repository;
        this.vkApiFacade = vkApiFacade;
    }

    @Override
    public String handleRequest(JsonObject object) {
        User requestSender;
        CallbackMessage<?> callbackMessage;
        JsonObject rowMessage = object.get("object")
                .getAsJsonObject()
                .get("message")
                .getAsJsonObject();

        Message message = gson.fromJson(rowMessage, Message.class);

        try {
            callbackMessage = parser.parse(object);
        } catch (VkCallbackParsingException e) {
            throw new RuntimeException("Invalid json object", e);
        }

        int userId = message.getFromId();

        if (repository.existsById(userId)){
            requestSender = repository.getById(userId);
        } else {
            requestSender = vkApiFacade.getUserData(userId);
            repository.save(requestSender);
        }

        notifyCallBackObservers(requestSender, callbackMessage);

        return "ok";
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
