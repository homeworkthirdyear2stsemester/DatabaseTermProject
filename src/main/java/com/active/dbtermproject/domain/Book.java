package com.active.dbtermproject.domain;

import lombok.Data;

@Data
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int isBorrow;
    private String Customid;
}
