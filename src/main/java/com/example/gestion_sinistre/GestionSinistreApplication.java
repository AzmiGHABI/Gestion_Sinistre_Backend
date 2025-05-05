package com.example.gestion_sinistre;

import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.gestion_sinistre")
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)

public class GestionSinistreApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestionSinistreApplication.class, args);
	}
}
