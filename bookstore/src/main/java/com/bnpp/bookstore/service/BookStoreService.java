package com.bnpp.bookstore.service;

import org.springframework.stereotype.Service;

import com.bnpp.bookstore.util.BookStoreUtil;

@Service
public class BookStoreService {
    private BookStoreUtil bookStore = new BookStoreUtil();

    public void addBook(String title, int quantity) {
        bookStore.addBook(title, quantity);
    }

    public double calculateTotalPrice() {
        return bookStore.calculateTotalPrice();
    }
}
