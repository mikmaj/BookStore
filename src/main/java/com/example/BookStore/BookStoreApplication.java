package com.example.BookStore;

import com.example.BookStore.controller.BookRepository;
import com.example.BookStore.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return args -> {
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 12.50));
			repository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 20.00));
		};
	}
}
