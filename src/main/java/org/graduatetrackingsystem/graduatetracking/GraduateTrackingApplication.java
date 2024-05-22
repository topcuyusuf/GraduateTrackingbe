package org.graduatetrackingsystem.graduatetracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GraduateTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduateTrackingApplication.class, args);
	}

}
