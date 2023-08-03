package com.raju.learning;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.raju.learning.model.Author;
import com.raju.learning.model.Book;
import com.raju.learning.repository.AuthorRepository;
import com.raju.learning.repository.BookRepository;

// @formatter:off

@SpringBootApplication
public class BooksApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@Bean
	CommandLineRunner init(BookRepository bookRepository, AuthorRepository authorRepository) {
		return args -> {
			var josh = authorRepository.save(Author.builder().name("Josh Long").build());
			var dan = authorRepository.save(Author.builder().name("Dan Vag").build());

			bookRepository.saveAll(List.of(
					Book.builder().author(josh).title("Spring Boot Version - 1").pages(384).build(),
					Book.builder().author(dan).title("Spring Boot Version - 2").pages(343).build(),
					Book.builder().author(josh).title("Spring Boot Version - 3").pages(392).build()));

		};
	}

}

// @formatter:on