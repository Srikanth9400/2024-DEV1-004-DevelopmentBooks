package com.bnpp.bookstore.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreUtilTest {

    @Autowired
    private BookStoreUtil bookStoreUtil;

    @Test
    public void testSingleBookPrice() {
        bookStoreUtil.addBook("Clean Code", 1);
        assertEquals(50.0, bookStoreUtil.calculateTotalPrice(), 0.00);
    }

    @Test
    public void testTwoDifferentBooksDiscount() {
        bookStoreUtil.addBook("Clean Code", 1);
        bookStoreUtil.addBook("The Clean Coder", 1);
        assertEquals(95.0, bookStoreUtil.calculateTotalPrice(), 0.00);
    }

    @Test
    public void testThreeDifferentBooksDiscount() {
        bookStoreUtil.addBook("Clean Code", 1);
        bookStoreUtil.addBook("The Clean Coder", 1);
        bookStoreUtil.addBook("Clean Architecture", 1);
        assertEquals(135.0, bookStoreUtil.calculateTotalPrice(), 0.00);
    }

    @Test
    public void testFourDifferentBooksDiscount() {
        bookStoreUtil.addBook("Clean Code", 1);
        bookStoreUtil.addBook("The Clean Coder", 1);
        bookStoreUtil.addBook("Clean Architecture", 1);
        bookStoreUtil.addBook("Test Driven Development by Example", 1);
        assertEquals(160.0, bookStoreUtil.calculateTotalPrice(), 0.00);
    }

    @Test
    public void testFiveDifferentBooksDiscount() {
        bookStoreUtil.addBook("Clean Code", 1);
        bookStoreUtil.addBook("The Clean Coder", 1);
        bookStoreUtil.addBook("Clean Architecture", 1);
        bookStoreUtil.addBook("Test Driven Development by Example", 1);
        bookStoreUtil.addBook("Working effectively with Legacy Code", 1);
        assertEquals(187.5, bookStoreUtil.calculateTotalPrice(), 0.00);
    }

    @Test
    public void testComplexBasket() {
        bookStoreUtil.addBook("Clean Code", 2);
        bookStoreUtil.addBook("The Clean Coder", 2);
        bookStoreUtil.addBook("Clean Architecture", 2);
        bookStoreUtil.addBook("Test Driven Development by Example", 1);
        bookStoreUtil.addBook("Working effectively with Legacy Code", 1);
        assertEquals(320.0, bookStoreUtil.calculateTotalPrice(), 0.00);
    }

    @Test
    public void testFourBooksThreeDifferentTitles() {
        bookStoreUtil.addBook("Clean Code", 1);
        bookStoreUtil.addBook("The Clean Coder", 1);
        bookStoreUtil.addBook("Clean Architecture", 1);
        bookStoreUtil.addBook("Clean Code", 1);  // Duplicate book

        // Expected price: 3 books with 10% discount + 1 full price book
        // (3 * 50 EUR) * 0.90 + 50 EUR = 135 EUR + 50 EUR = 185 EUR
        assertEquals(185.0, bookStoreUtil.calculateTotalPrice(), 0.00);
    }
}
