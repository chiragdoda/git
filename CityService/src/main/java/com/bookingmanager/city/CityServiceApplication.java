package com.bookingmanager.city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages="com.bookingmanager.city.*")
@Import(value=CityConfig.class)
public class CityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityServiceApplication.class, args);
	}
}
