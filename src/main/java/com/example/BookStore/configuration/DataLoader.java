package com.example.BookStore.configuration;

import com.example.BookStore.model.Book;
import com.example.BookStore.model.Category;
import com.example.BookStore.model.User;
import com.example.BookStore.repository.UserRepository;
import com.example.BookStore.repository.BookRepository;
import com.example.BookStore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {

        Category category = new Category();
        Category category1 = new Category();

        category.setName("Crime");
        category1.setName("Fiction");

        category = categoryRepository.save(category);
        category1 = categoryRepository.save(category1);

        Book book = new Book();
        Book book2 = new Book();

        book.setTitle("The Handmaid's Tale");
        book.setAuthor("Margaret Atwood");
        book.setIsbn("9781784870966");
        book.setPrice(20.00);
        book.setYear(1859);
        book.setCategory(category);

        book2.setTitle("The Subtle Art of Not Giving a Fuck");
        book2.setAuthor("Mark Manson");
        book2.setIsbn("9780062457714");
        book2.setPrice(19.00);
        book2.setYear(2011);
        book2.setCategory(category1);

        bookRepository.save(book);
        bookRepository.save(book2);

        User user1 = new User();
        User user2 = new User();

        user1.setUsername("user");
        user1.setPasswordHash("$2b$10$1XT6tPmXStwLhL7ELQPHVeSqCWXpjIdKzM7vWiTph./tWjPMr8AqS");
        user1.setRole("USER");

        user2.setUsername("admin");
        user2.setPasswordHash("$2b$10$b6uvmjCFNQoZ.gYVsY5DcuFeNPcL.PZsJWf3HZB17SjHmFjoFufxu");
        user2.setRole("ADMIN");


        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);
    }
}
