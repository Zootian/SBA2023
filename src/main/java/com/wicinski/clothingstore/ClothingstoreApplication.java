package com.wicinski.clothingstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ClothingstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClothingstoreApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PersonRepository personRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				Person person = new Person(name, name.toLowerCase() + "@domain.com");
				personRepository.save(person);
			});
			personRepository.findAll().forEach(System.out::println);
		};
	}

}
