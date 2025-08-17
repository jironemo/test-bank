package com.testbank.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {
    private Long id;
    private String accountFrom;
    private String accountTo;
    private double amount;
}
