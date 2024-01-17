package com.example.ordermanagement.model;

import java.math.BigDecimal;

public class Order {
    private String orderId;
    private String foodSelection;
    private int quantity;
    private String specialRequest;
    private Address deliveryAddress;
    private String paymentMethod;
    private PaymentMethodType paymentMethodType;
    private BigDecimal orderAmount;
    private String orderStatus;
    private String estimatedDeliveryTime;

    // Getters and setters for all fields
    // ...
}