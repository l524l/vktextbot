package com.l524l.vktextbot.user;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bot_user")
public class User {

    @Id
    private int id;
    private String firstName;
    private String lastName;

    @Enumerated
    private WorkMode workMode;
    @Enumerated
    @ElementCollection
    private List<UserRole> roles;
    private boolean banned;

    public User() {
        this.roles = new ArrayList<>();
    }

    public static User createNewDefaultUser(int id, String firstName, String lastName) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBanned(false);
        user.setWorkMode(WorkMode.TEXT_FLIP);
        user.addRole(UserRole.USER);

        return user;
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

    public WorkMode getWorkMode() {
        return workMode;
    }

    public void setWorkMode(WorkMode workMode) {
        this.workMode = workMode;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public void addRole(UserRole role) {
        if (!roles.contains(role)){
            roles.add(role);
        }
    }

    public boolean hasRole(UserRole role) {
        return roles.contains(role);
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
}
