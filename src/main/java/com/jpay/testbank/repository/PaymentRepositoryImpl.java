package com.jpay.testbank.repository;

import com.jpay.testbank.model.PaymentInfo;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
    @Override
    public void save(PaymentInfo paymentInfo) {
        // Simulate saving payment info (e.g., to a database)
        // In a real application, implement actual persistence logic here
    }
}
