package com.example.userordermanagement.dto;

import com.example.userordermanagement.domain.Address;
import lombok.Data;

@Data
public class PlaceOrderCommand {
    private String foodSelection;
    private Integer quantity;
    private String specialRequest;
    private Address deliveryAddress;
    private String paymentMethod;
}