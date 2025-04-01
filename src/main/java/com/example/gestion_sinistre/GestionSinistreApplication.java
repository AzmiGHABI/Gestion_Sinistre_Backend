package com.example.gestion_sinistre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.gestion_sinistre")
public class GestionSinistreApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestionSinistreApplication.class, args);
	}
}
