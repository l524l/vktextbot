package com.l524l.vktextbot.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private WorkMode currentWorkMode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WorkMode getCurrentWorkMode() {
        return currentWorkMode;
    }

    public void setCurrentWorkMode(WorkMode currentWorkMode) {
        this.currentWorkMode = currentWorkMode;
    }

    public UserSettings getDefaultSettings(){
        currentWorkMode = WorkMode.TEXT_FLIP;
        return this;
    }
}
