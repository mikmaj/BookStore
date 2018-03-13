package com.example.BookStore;

import com.example.BookStore.repository.BookRepository;
import com.example.BookStore.model.Book;
import com.example.BookStore.model.Category;
import com.example.BookStore.repository.CategoryRepository;
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
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return args -> {
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Crime"));
			crepository.save(new Category("Children"));

			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 12.50, crepository.findByName("Horror").get(0)));
			repository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 20.00, crepository.findByName("Horror").get(0)));
		};
	}
}
