package com.l524l.vktextbot.vk;

import com.vk.api.sdk.client.actors.GroupActor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "vk.group-actor")
@Component
public class GroupActorConfig {
    @Value("${vk.group-actor.group-id}")
    private int groupId;
    @Value("${vk.group-actor.access-token}")
    private String accessToken;
    @Value("${vk.group-actor.secret}")
    private String secret;
    @Value("${vk.group-actor.confirmation-token}")
    private String confirmationToken;

    @Bean
    public GroupActor createGroupActor(){
        return new GroupActor(groupId, accessToken);
    }

    public int getGroupId() {
        return groupId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getSecret() {
        return secret;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }
}
