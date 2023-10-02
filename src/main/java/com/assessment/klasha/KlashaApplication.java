package com.assessment.klasha;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class KlashaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KlashaApplication.class, args);
	}

}
