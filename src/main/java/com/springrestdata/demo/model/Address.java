package com.springrestdata.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@ToString
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    private String street;

    @Getter
    @Setter
    private String zipCode;

    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private String state;

    protected Address() {}

    public Address(String street, String zipCode, String city, String state) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }
}
