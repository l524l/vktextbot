package com.l524l.vktextbot.vk;

import com.l524l.vktextbot.user.User;
import com.l524l.vktextbot.user.UserRole;
import com.l524l.vktextbot.user.WorkMode;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.users.responses.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    }

    public void sendMessage(String text, User user){
        try {
            apiClient.messages()
                    .send(groupActor)
                    .chatId(user.getId())
                    .message(text)
                    .execute();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public User getUserData(int id) {
        User user = new User();
        try {
            GetResponse response = apiClient.users()
                    .get(groupActor)
                    .userIds(String.valueOf(id))
                    .execute()
                    .get(0);
            user.setId(id);
            user.setFirstName(response.getFirstName());
            user.setLastName(response.getLastName());
            user.setBanned(false);
            user.setWorkMode(WorkMode.TEXT_FLIP);
            user.setRole(UserRole.USER);

        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return user;
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
