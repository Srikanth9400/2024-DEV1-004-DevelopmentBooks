package com.bnpp.bookstore.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bnpp.bookstore.service.BookStoreService;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreUtilTest {

    @Autowired
    private BookStoreService bookStoreService;

    @Test
    public void testSingleBookPrice() {
        bookStoreService.addBook("Clean Code", 1);
        assertEquals(50.0, bookStoreService.calculateTotalPrice(), 0.00);
    }

    @Test
    public void testTwoDifferentBooksDiscount() {
        bookStoreService.addBook("Clean Code", 1);
        bookStoreService.addBook("The Clean Coder", 1);
        assertEquals(95.0, bookStoreService.calculateTotalPrice(), 0.00);
    }

    @Test
    public void testThreeDifferentBooksDiscount() {
        bookStoreService.addBook("Clean Code", 1);
        bookStoreService.addBook("The Clean Coder", 1);
        bookStoreService.addBook("Clean Architecture", 1);
        assertEquals(135.0, bookStoreService.calculateTotalPrice(), 0.00);
    }

    @Test
    public void testFourDifferentBooksDiscount() {
        bookStoreService.addBook("Clean Code", 1);
        bookStoreService.addBook("The Clean Coder", 1);
        bookStoreService.addBook("Clean Architecture", 1);
        bookStoreService.addBook("Test Driven Development by Example", 1);
        assertEquals(160.0, bookStoreService.calculateTotalPrice(), 0.00);
    }

    @Test
    public void testFiveDifferentBooksDiscount() {
        bookStoreService.addBook("Clean Code", 1);
        bookStoreService.addBook("The Clean Coder", 1);
        bookStoreService.addBook("Clean Architecture", 1);
        bookStoreService.addBook("Test Driven Development by Example", 1);
        bookStoreService.addBook("Working effectively with Legacy Code", 1);
        assertEquals(187.5, bookStoreService.calculateTotalPrice(), 0.00);
    }

    @Test
    public void testComplexBasket() {
        bookStoreService.addBook("Clean Code", 2);
        bookStoreService.addBook("The Clean Coder", 2);
        bookStoreService.addBook("Clean Architecture", 2);
        bookStoreService.addBook("Test Driven Development by Example", 1);
        bookStoreService.addBook("Working effectively with Legacy Code", 1);
        assertEquals(320.0, bookStoreService.calculateTotalPrice(), 0.00);
    }

    @Test
    public void testFourBooksThreeDifferentTitles() {
        bookStoreService.addBook("Clean Code", 1);
        bookStoreService.addBook("The Clean Coder", 1);
        bookStoreService.addBook("Clean Architecture", 1);
        bookStoreService.addBook("Clean Code", 1);  // Duplicate book

        // Expected price: 3 books with 10% discount + 1 full price book
        // (3 * 50 EUR) * 0.90 + 50 EUR = 135 EUR + 50 EUR = 185 EUR
        assertEquals(185.0, bookStoreService.calculateTotalPrice(), 0.00);
    }
}
