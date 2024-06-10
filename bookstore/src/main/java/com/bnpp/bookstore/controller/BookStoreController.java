package com.bnpp.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bnpp.bookstore.service.BookStoreService;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {

    @Autowired
    private BookStoreService bookStoreService;

    @PostMapping("/addBook")
    public void addBook(@RequestParam String title, @RequestParam int quantity) {
        bookStoreService.addBook(title, quantity);
    }

    @GetMapping("/calculateTotalPrice")
    public double calculateTotalPrice() {
        return bookStoreService.calculateTotalPrice();
    }
}
