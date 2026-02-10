package com.jpay.testbank.repository;

import com.jpay.testbank.model.PaymentInfo;

public interface PaymentRepository {
    void save(PaymentInfo paymentInfo);
}
