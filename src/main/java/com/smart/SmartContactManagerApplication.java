package com.smart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.smart.config.ActiveProfiles;
import com.smart.exception.SetProfileException;

@SpringBootApplication
public class SmartContactManagerApplication implements ApplicationRunner {

	@Autowired
	private ActiveProfiles activeProfiles;

	public static void main(String[] args) {
		SpringApplication.run(SmartContactManagerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws IllegalStateException {

		activeProfiles.isProfileSet();
	}

}
