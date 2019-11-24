package com.active.dbtermproject.domain;

import lombok.Data;

@Data
public class Customer {
    private String id;
    private String password;
    private String email;
    private String name;
    private String phone_number;
    private String type;
}
