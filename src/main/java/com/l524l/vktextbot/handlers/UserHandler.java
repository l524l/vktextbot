package com.l524l.vktextbot.handlers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.l524l.vktextbot.database.UserRepository;
import com.l524l.vktextbot.user.User;
import com.l524l.vktextbot.vk.VkApiFacade;
import com.l524l.vktextbot.vk.VkCallBackObserver;
import com.l524l.vktextbot.vk.VkCallBackRequest;
import com.l524l.vktextbot.vk.VkCallBackSubject;
import com.vk.api.sdk.callback.CallbackApi;
import com.vk.api.sdk.objects.messages.Message;

import java.util.ArrayList;
import java.util.List;

public class UserHandler extends RequestHandler implements VkCallBackSubject {

    private UserRepository repository;
    private VkApiFacade vkApiFacade;
    private List<VkCallBackObserver> observers;

    public UserHandler(UserRepository repository, VkApiFacade vkApiFacade) {
        observers = new ArrayList<>();
        this.repository = repository;
        this.vkApiFacade = vkApiFacade;
    }

    @Override
    public String handleRequest(JsonObject object) {
        JsonObject message = object.get("object")
                .getAsJsonObject()
                .get("message")
                .getAsJsonObject();

        Gson gson = new Gson();
        Message message1 = gson.fromJson(message, Message.class);

        int userId = message1.getFromId();
        int peerId = message1.getPeerId();


        User requestSender;
        if (repository.existsById(userId)){
            requestSender = repository.getById(userId);
        } else {
            requestSender = vkApiFacade.getUserData(userId);
            repository.save(requestSender);
        }
        VkCallBackRequest request = new VkCallBackRequest(requestSender,object);
        notifyCallBackObservers(request);

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
    public void notifyCallBackObservers(VkCallBackRequest request) {
        if (observers.isEmpty()) return;

        observers.forEach((x)-> x.update(request));
    }
}
