package com.l524l.vktextbot.user;

import javax.persistence.*;

@Entity
public class User {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private UserSettings settings;
    private UserRole role;
    private boolean banned;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public UserSettings getSettings() {
        return settings;
    }

    public void setSettings(UserSettings settings) {
        this.settings = settings;
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
