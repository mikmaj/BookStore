package com.example.BookStore.controller;

import java.util.List;

import com.example.BookStore.model.Book;
import com.example.BookStore.controller.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    // Show all books
    @RequestMapping(value="/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    // RESTful service to get all books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> studentListRest() {
        return (List<Book>) repository.findAll();
    }

    // RESTful service to get book by id
    @RequestMapping(value="/book/{id}", method=RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
        return repository.findOne(bookId);
    }

    // Add new book
    @RequestMapping(value="/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }

    // Save new book
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    // Delete book
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        repository.delete(id);
        return "redirect:../booklist";
    }

    // Edit book
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", repository.findOne(id));
        model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }

    /*@GetMapping("/index")
    public String hello() {
        return "This is my bookstore application";
    }*/
}
