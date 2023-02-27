package org.example.bookcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EntityScan("org.example.bookcase.model")
@EnableJpaRepositories("org.example.bookcase.repository")
public class BookcaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookcaseApplication.class, args);
	}

}
