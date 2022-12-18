package com.smart.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.smart.exception.SetProfileException;

@Component
public class ActiveProfiles {

	private final Environment environment;

	private final Logger logger = LoggerFactory.getLogger(ActiveProfiles.class);

	public ActiveProfiles(Environment environment) {
		this.environment = environment;
	}

	public void isProfileSet() {
		Arrays.stream(environment.getActiveProfiles()).forEach(c -> {
			if (c.equals("${profile}")) {
				logger.error("PLEASE SET PROFILE EG. PROD, TEST");
				throw new SetProfileException("please set profile eg. prod, test");
			}
		});
	}

}
