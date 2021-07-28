package com.l524l.vktextbot;

import com.google.gson.JsonObject;
import com.l524l.vktextbot.vk.VkCallBackObserver;
import com.l524l.vktextbot.vk.VkCallBackSubject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class VkCallBackReceiver implements VkCallBackSubject {

    private JsonObject currentCallback;
    private ArrayList<VkCallBackObserver> observersList;

    public VkCallBackReceiver() {
        observersList = new ArrayList<>();
    }

    @RequestMapping("/")
    public @ResponseBody String onVkCallBackReceived(@RequestBody JsonObject callBack){
        currentCallback = callBack;
        notifyCallBackObservers();
        return "ok";
    }

    public void registerCallBackObserver(VkCallBackObserver observer){
        observersList.add(observer);
    }
    public void removeCallBackObserver(VkCallBackObserver observer){
        if (observersList.contains(observer)) observersList.remove(observer);
    }

    @Override
    public void notifyCallBackObservers() {
        observersList.forEach((o)-> o.update(currentCallback));
    }
}
