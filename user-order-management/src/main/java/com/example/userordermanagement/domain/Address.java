package com.example.userordermanagement.domain;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}