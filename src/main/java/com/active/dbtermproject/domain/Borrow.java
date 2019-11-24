package com.active.dbtermproject.domain;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Borrow {
    private int borrowNumber;
    private String isbn;
    private String title;
    private String customerId;
    private Date borrowDate;
    private Date returnDate;
    private int isReturn;

}
