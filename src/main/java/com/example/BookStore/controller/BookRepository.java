package com.example.BookStore.controller;

import com.example.BookStore.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByAuthor(String author);
}