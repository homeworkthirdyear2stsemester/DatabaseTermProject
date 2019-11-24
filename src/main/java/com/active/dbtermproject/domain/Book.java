package com.active.dbtermproject.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int isBorrow;
    private String customerId;

    public Book() {
    }

    @Builder
    public Book(String isbn, String title, String author, String publisher, int isBorrow, String customerId) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isBorrow = isBorrow;
        this.customerId = customerId;
    }
}
