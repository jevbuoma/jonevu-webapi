package com.springrestdata.demo.beans;

import com.springrestdata.demo.model.Auction;
import com.springrestdata.demo.model.User;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class CsvDataLoader {

    @Bean
    public Auction buildAuctionFromCsv() throws IOException {
        Auction auction = new Auction("1234", 20);
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/users_information.csv"))) {
            String line = null;
            do {
                line = reader.readLine();
                if (line != null) {
                    User user = new User(line);
                    user.setRequestId(UUID.randomUUID().toString());
                    user.setRegistered(false);
                    auction.addUser(user);
                }
            } while(line !=null);
        }
        return auction;
    }
}
