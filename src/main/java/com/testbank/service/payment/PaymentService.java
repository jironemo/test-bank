package com.testbank.service.payment;

import com.testbank.model.PaymentInfo;

public interface PaymentService {
    void processPayment(PaymentInfo paymentInfo);
}
