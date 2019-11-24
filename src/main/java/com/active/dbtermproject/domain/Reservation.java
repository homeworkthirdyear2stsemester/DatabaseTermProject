package com.active.dbtermproject.domain;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Reservation {
    private String customerId;
    private String isbn;
    private Date reservDate;
}
