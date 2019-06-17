package com.plantplaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication//: ne zice ca avem aici o aplicatie Spring Boot - de aici pleaca totul
@EnableCaching // metionezi ca se poate cache-ui informatie in aceasta aplicatie
public class PlantPlacesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantPlacesApplication.class, args);
	}

}

