package com.l524l.vktextbot.exteptions;

public class VkCallbackParsingException extends BotException {
    public VkCallbackParsingException () {
        super("Invalid Vk callback");
    }
    public VkCallbackParsingException (String message) {
        super(message);
    }
}
