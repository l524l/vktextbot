package com.l524l.vktextbot;

import com.google.gson.JsonObject;
import com.vk.api.sdk.callback.CallbackApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/")
    public @ResponseBody String onVkCallBackReceived(@RequestBody JsonObject callBack){
        return "ok";
    }
}
