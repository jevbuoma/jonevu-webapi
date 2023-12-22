package com.springrestdata.demo;

import com.springrestdata.demo.beans.CsvDataLoader;
import com.springrestdata.demo.model.Address;
import com.springrestdata.demo.model.Auction;
import com.springrestdata.demo.model.User;
import com.springrestdata.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@Import(CsvDataLoader.class)
public class DemoApplication {

	@Autowired
	private Auction auction;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner configureRepository(UserRepository userRepository) {
		AtomicInteger number = new AtomicInteger(1);
		return args -> {
			for (User user : auction.getUsers()) {
				user.setAddress(generateAddress(String.valueOf(number.getAndIncrement())));
				userRepository.save(user);
			}
		};
	}

	private static Address generateAddress(String number) {
		return new Address(number + " Flowers Streets", "12345", "Boston", "MA");
	}
}
