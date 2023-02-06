package io.nirmitee.roy.workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
@EnableWebMvc

public class SpringFoxConfig {
	@Bean
	OpenAPI baseOpenAPI() {
		return new OpenAPI().info(new Info().title("Vehicle Information Api").summary("Create A REST API to maintain vehicle data and to provide a complete view of vehicle details including price and\r\n"
				+ "address.").version("1.0.0").description("Rest Endpoints for CRUD operations on Vehicle API").contact(getContact()));
	}

	private Contact getContact() {
		// TODO Auto-generated method stub
		return new Contact().name("Abhishek Roy").email("imroy@gmail.com").url("https://github.com/AbhishekRoy-1");
	}

}
