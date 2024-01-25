package com.example.userordermanagement.domain;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Money {
    private BigDecimal amount;
    private String currency;
}