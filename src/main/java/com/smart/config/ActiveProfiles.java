package com.smart.config;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.smart.exception.SetProfileException;

@Component
public class ActiveProfiles {

	private final Environment environment;

	public ActiveProfiles(Environment environment) {
		this.environment = environment;
	}

	public void isProfileSet() {
		String[] activeProfiles = environment.getActiveProfiles();
		Arrays.stream(activeProfiles).forEach(c -> {
			if(c.equals("${profile}")) {
				System.err.println("PLEASE SET PROFILE EG. PROD, TEST");
				throw new SetProfileException("please set profile eg. prod, test");
			}
		});
	}

}
