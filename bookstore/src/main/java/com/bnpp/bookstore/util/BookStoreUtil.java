package com.bnpp.bookstore.util;

import java.util.*;

public class BookStoreUtil {

    private static final double BOOK_PRICE = 50.0;
    private static final Map<Integer, Double> DISCOUNTS = new HashMap<>();
    private Map<String, Integer> books = new HashMap<>();

    static {
        DISCOUNTS.put(1, 1.0);
        DISCOUNTS.put(2, 0.95);
        DISCOUNTS.put(3, 0.90);
        DISCOUNTS.put(4, 0.80);
        DISCOUNTS.put(5, 0.75);
    }

    public void addBook(String title, int quantity) {
        books.put(title, books.getOrDefault(title, 0) + quantity);
    }

    public double calculateTotalPrice() {
        List<Integer> quantities = new ArrayList<>(books.values());
        double total = 0.0;

        while (!quantities.isEmpty()) {
            int distinctBooks = 0;
            for (int i = 0; i < quantities.size(); i++) {
                if (quantities.get(i) > 0) {
                    quantities.set(i, quantities.get(i) - 1);
                    distinctBooks++;
                }
            }
            if (distinctBooks == 0) break;
            
            double discount = DISCOUNTS.getOrDefault(distinctBooks, 1.0);
            total += distinctBooks * BOOK_PRICE * discount;
            quantities.removeIf(quantity -> quantity == 0);
        }
        return total;
    }
}
