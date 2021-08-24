package com.l524l.vktextbot.vk;

import com.l524l.vktextbot.user.User;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.users.responses.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class VkApiFacade {

    private GroupActor groupActor;
    private HttpTransportClient httpClient;
    private VkApiClient apiClient;

    @Autowired
    public VkApiFacade(GroupActor groupActor) {
        this(HttpTransportClient.getInstance(), groupActor);
    }

    public VkApiFacade(HttpTransportClient transportClient, GroupActor groupActor) {
        this.groupActor = groupActor;
        this.httpClient = transportClient;
        apiClient = new VkApiClient(httpClient);
        apiClient.setVersion("5.131");
    }

    public void sendMessage(String text, User user){
        sendMessage(text, user.getId());
    }

    public void sendMessage(String text, int peerId){
        Random random = new Random();
        try {
            apiClient.messages()
                    .send(groupActor)
                    .peerId(peerId)
                    .randomId(random.nextInt())
                    .message(text)
                    .execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    // FIXME: 21.08.2021 Return null is bad practice
    public User getUserData(int id) {
        try {
            GetResponse response = apiClient.users()
                    .get(groupActor)
                    .userIds(String.valueOf(id))
                    .execute()
                    .get(0);
            return User.createNewDefaultUser(
                        id,
                        response.getFirstName(),
                        response.getLastName());

        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GroupActor getGroupActor() {
        return groupActor;
    }

    public void setGroupActor(GroupActor groupActor) {
        this.groupActor = groupActor;
    }

    public VkApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(VkApiClient apiClient) {
        this.apiClient = apiClient;
    }
}
