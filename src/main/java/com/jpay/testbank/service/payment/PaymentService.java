package com.jpay.testbank.service.payment;

import com.jpay.testbank.model.PaymentInfo;

public interface PaymentService {
    void processPayment(PaymentInfo paymentInfo);
}
