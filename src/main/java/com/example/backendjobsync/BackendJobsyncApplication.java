package com.example.backendjobsync;

import com.example.backendjobsync.Entities.Role;
import com.example.backendjobsync.Entities.User;
import com.example.backendjobsync.Services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BackendJobsyncApplication {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BackendJobsyncApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){return new BCryptPasswordEncoder();}




}
