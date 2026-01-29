package com.testbank.repository;

import com.testbank.model.PaymentInfo;

public interface PaymentRepository {
    void save(PaymentInfo paymentInfo);
}
