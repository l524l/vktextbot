package com.l524l.vktextbot.user.loaders;

import com.l524l.vktextbot.user.User;
import com.l524l.vktextbot.vk.VkDataSender;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VkUserLoader implements UserLoader {

    private final VkDataSender dataSender;

    public VkUserLoader(VkDataSender dataSender) {
        this.dataSender = dataSender;
    }

    @Override
    public Optional<User> loadUser(int id) {
        User user = dataSender.getUserData(id);
        return Optional.ofNullable(user);
    }
}
