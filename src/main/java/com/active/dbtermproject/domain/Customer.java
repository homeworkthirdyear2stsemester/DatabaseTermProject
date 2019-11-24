package com.active.dbtermproject.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Customer {
    private String id;
    private String password;
    private String email;
    private String name;
    private String phoneNumber;
    private String type;

    public Customer() {
    }

    @Builder
    public Customer(String id, String password, String email, String name, String phoneNumber, String type) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }
}
