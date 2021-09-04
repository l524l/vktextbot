package com.l524l.vktextbot.user;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "bot_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private int id;
    private String firstName;
    private String lastName;
    @Enumerated
    private UserFrom userFrom;
    @Enumerated
    private WorkMode workMode;
    @Enumerated
    private UserRole role;
    private boolean banned;

    public static User createNewDefaultUser(int id, String firstName, String lastName, UserFrom userFrom) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBanned(false);
        user.setWorkMode(WorkMode.TEXT_FLIP);
        user.setRole(UserRole.USER);
        user.setUserFrom(userFrom);

        return user;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserFrom getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(UserFrom userFrom) {
        this.userFrom = userFrom;
    }

    public WorkMode getWorkMode() {
        return workMode;
    }

    public void setWorkMode(WorkMode workMode) {
        this.workMode = workMode;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
}
