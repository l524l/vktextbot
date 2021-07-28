package com.l524l.vktextbot.vk;

public interface VkCallBackSubject {
    public void registerCallBackObserver(VkCallBackObserver observer);
    public void removeCallBackObserver(VkCallBackObserver observer);
    public void notifyCallBackObservers();
}
