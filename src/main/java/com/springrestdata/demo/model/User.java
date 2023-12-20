package com.springrestdata.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.*;

@Entity
@ToString
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    @Getter
    @Setter
    private String requestId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    //@JsonIgnore --- Use this annotation to prevent this attribute from being displayed
    private boolean isRegistered;

    @Getter
    @Setter
    private boolean isCitizen;

    protected  User() {}

    public User(String name) {
        this.name = name;
    }
}
