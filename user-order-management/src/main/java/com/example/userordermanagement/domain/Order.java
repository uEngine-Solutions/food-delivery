package com.example.userordermanagement.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private String foodSelection;
    private Integer quantity;
    private String specialRequest;
    private Address deliveryAddress;
    private String paymentMethod;
    private PaymentMethodType paymentMethodType;
    private Money orderAmount;
    private String orderStatus;
    private String estimatedDeliveryTime;
}