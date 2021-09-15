package com.l524l.vktextbot.configurations;

import com.l524l.vktextbot.handlers.RequestHandler;
import com.l524l.vktextbot.handlers.RequestHandlersChainBuilder;
import com.l524l.vktextbot.handlers.vk.BaseRequestHandler;
import com.l524l.vktextbot.handlers.vk.ConfirmationHandler;
import com.l524l.vktextbot.handlers.vk.SecretHandler;
import com.l524l.vktextbot.handlers.vk.NewMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainRequestHandlerConfig {

    @Autowired
    private SecretHandler secretHandler;
    @Autowired
    private ConfirmationHandler confirmationHandler;
    @Autowired
    private BaseRequestHandler baseRequestHandler;
    @Autowired
    private NewMessageHandler newMessageHandler;
    @Autowired
    private RequestHandlersChainBuilder builder;

    @Bean(name = "mainHandler")
    public RequestHandler createMainRequestHandler() {

        builder.addHandler(baseRequestHandler);
        builder.addHandler(secretHandler);
        builder.addHandler(confirmationHandler);
        builder.addHandler(newMessageHandler);

        return builder.buildChain();
    }
}
