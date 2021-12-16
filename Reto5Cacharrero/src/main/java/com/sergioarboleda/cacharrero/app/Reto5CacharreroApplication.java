package com.sergioarboleda.cacharrero.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * 
 * @author Carotobarj
 */

@SpringBootApplication
@EntityScan(basePackages = {"com.sergioarboleda.cacharrero.app.model"})

public class Reto5CacharreroApplication {

	public static void main(String[] args) {
		SpringApplication.run(Reto5CacharreroApplication.class, args);
	}

}