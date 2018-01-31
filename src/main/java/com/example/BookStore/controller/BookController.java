package com.example.BookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookController {
    @GetMapping("/index")
    public String hello() {
        return "This is my bookstore application";
    }
}
