package com.l524l.vktextbot.vk;

public interface VkCallBackSubject {
    void registerCallBackObserver(VkCallBackObserver observer);
    void removeCallBackObserver(VkCallBackObserver observer);
    void notifyCallBackObservers(VkCallBackRequest request);
}
