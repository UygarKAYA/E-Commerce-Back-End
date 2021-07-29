package com.example.ecommerce;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository userRepository)
	{
		return args -> {
			User user = new User("Uygar", "Kaya", "uygarkaya@gmail.com", "UKAYA", "uygarkaya", LocalDateTime.now());
			userRepository.insert(user);
		};
	}

}
