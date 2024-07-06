package com.ata.it.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ata.it.backend.repository")
@EntityScan("com.ata.it.backend.model")
public class AtaItBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtaItBackendApplication.class, args);
	}

}
