package com.pitchinsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class PitchinsightApplication {

	public static void main(String[] args) {
		SpringApplication.run(PitchinsightApplication.class, args);
	}

}
