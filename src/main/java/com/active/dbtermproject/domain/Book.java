package com.active.dbtermproject.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int isBorrow;
    private String customerId;
}
