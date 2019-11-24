package com.active.dbtermproject.domain;

import lombok.Data;

@Data
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int is_borrow;
    private String Customid;
}
