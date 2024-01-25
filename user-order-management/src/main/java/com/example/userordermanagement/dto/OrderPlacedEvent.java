package com.example.userordermanagement.dto;

import com.example.userordermanagement.domain.Address;
import com.example.userordermanagement.domain.Money;
import lombok.Data;

@Data
public class OrderPlacedEvent {
    private String orderId;
    private String foodSelection;
    private Integer quantity;
    private String specialRequest;
    private Address deliveryAddress;
    private String paymentMethod;
    private Money orderAmount;
}