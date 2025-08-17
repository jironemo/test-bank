package com.testbank.payment.service;

import com.testbank.payment.model.PaymentInfo;

public interface PaymentService {
    void processPayment(PaymentInfo paymentInfo);
}
