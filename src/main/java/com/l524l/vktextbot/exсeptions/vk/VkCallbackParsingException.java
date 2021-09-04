package com.l524l.vktextbot.exсeptions.vk;

import com.l524l.vktextbot.exсeptions.BotException;

public class VkCallbackParsingException extends BotException {
    public VkCallbackParsingException () {
        super("Invalid Vk callback");
    }
    public VkCallbackParsingException (String message) {
        super(message);
    }
}
