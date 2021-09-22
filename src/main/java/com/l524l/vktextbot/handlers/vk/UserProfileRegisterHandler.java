package com.l524l.vktextbot.handlers.vk;

import com.google.gson.JsonObject;
import com.l524l.vktextbot.database.UserRepository;
import com.l524l.vktextbot.handlers.RequestHandler;
import com.l524l.vktextbot.user.User;
import com.l524l.vktextbot.vk.VkCallbackParser;
import com.l524l.vktextbot.vk.VkDataSender;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterHandler extends RequestHandler {

    private final UserRepository userRepository;
    private final VkDataSender vkDataSender;
    private final VkCallbackParser callbackParser;

    @Autowired
    public UserProfileRegisterHandler(UserRepository userRepository, VkDataSender vkDataSender, VkCallbackParser callbackParser) {
        this.userRepository = userRepository;
        this.vkDataSender = vkDataSender;
        this.callbackParser = callbackParser;
    }

    @Override
    public String handleRequest(JsonObject object) {
        try {
            CallbackMessage<?> callback = callbackParser.parse(object);
            Message message = (Message) callback.getObject();
            int fromId = message.getFromId();

            if (!userRepository.existsById(fromId)) {
                User user = vkDataSender.getUserData(fromId);
                userRepository.save(user);
            }

            return handleByNextHandler(object);

        } catch (Exception e) {
            return "ok";
        }
    }
}
