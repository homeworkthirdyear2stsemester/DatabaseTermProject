package com.active.dbtermproject.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private String id;
    private String password;
    private String email;
    private String name;
    private String phoneNumber;
    private String type;
}
