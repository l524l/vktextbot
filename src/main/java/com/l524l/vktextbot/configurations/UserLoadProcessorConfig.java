package com.l524l.vktextbot.configurations;

import com.l524l.vktextbot.user.loaders.DataBaseUserLoader;
import com.l524l.vktextbot.user.loaders.UserLoadProcessor;
import com.l524l.vktextbot.user.loaders.VkUserLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserLoadProcessorConfig {

    @Autowired
    private DataBaseUserLoader dataBaseUserLoader;
    @Autowired
    private VkUserLoader vkUserLoader;

    @Bean
    public UserLoadProcessor createUserLoadProcessor() {
        UserLoadProcessor userLoadProcessor = new UserLoadProcessor();

        userLoadProcessor.addLoader(dataBaseUserLoader);
        userLoadProcessor.addLoader(vkUserLoader);

        return userLoadProcessor;
    }

}
