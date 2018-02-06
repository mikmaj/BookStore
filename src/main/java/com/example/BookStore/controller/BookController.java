package com.example.BookStore.controller;

import com.example.BookStore.model.Book;
import com.example.BookStore.controller.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @RequestMapping(value="/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value="/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        repository.delete(id);
        return "redirect:../booklist";
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", repository.findOne(id));
        return "editbook";
    }

    /*@GetMapping("/index")
    public String hello() {
        return "This is my bookstore application";
    }*/
}
