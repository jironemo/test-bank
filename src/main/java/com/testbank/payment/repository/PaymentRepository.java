package com.testbank.payment.repository;

import com.testbank.payment.model.PaymentInfo;

public interface PaymentRepository {
    void save(PaymentInfo paymentInfo);
}
