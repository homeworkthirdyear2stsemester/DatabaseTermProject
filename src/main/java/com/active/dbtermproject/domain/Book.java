package com.active.dbtermproject.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    public String isbn;
    public String title;
    public String author;
    public String publisher;
    public int isBorrow;
    public String customerId;
}
