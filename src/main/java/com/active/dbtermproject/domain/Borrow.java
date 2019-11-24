package com.active.dbtermproject.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Borrow {

    private int borrow_number;
    private String isbn;
    private String title;
    private String user_id;
    private Date borrow_date;
    private Date return_date;
    private int is_return;

}
