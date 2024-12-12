package com.rps.projetodois;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetodoisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetodoisApplication.class, args);
	}

	// @Bean
	// CommandLineRunner init(ScoreRepository scoreRepo) {
	// 	return args -> {
	// 		scoreRepo.save(new Score());
	// 	};
	// }

}
