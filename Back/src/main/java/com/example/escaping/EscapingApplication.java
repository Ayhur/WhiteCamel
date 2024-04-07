package com.example.escaping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscapingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscapingApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
//			}
//		};
//	}

}
