package com.springrestdata.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    protected  User() {}

    public User(String name) {
        this.name = name;
    }
}
