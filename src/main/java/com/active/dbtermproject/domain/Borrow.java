package com.active.dbtermproject.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Borrow {
    private int borrowNumber;
    private String isbn;
    private String title;
    private String userId;
    private Date borrowDate;
    private Date returnDate;
    private int isReturn;

}
