package com.springrestdata.demo.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ToString
public class Auction {

    @Getter
    private final String auctionNumber;

    private final int seats;
    private final Set<User> users = new HashSet<>();

    public Auction(String auctionNumber, int seats) {
        this.auctionNumber = auctionNumber;
        this.seats = seats;
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public boolean addUser(User user) {
        if (users.size() >= seats) {
            throw new RuntimeException("Cannot add more uses than the capacityof the acutioneers");
        }
        return users.add(user);
    }

    public boolean removeUser(User user) {
        return users.remove(user);
    }
}
