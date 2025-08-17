package com.testbank.payment.service;

import com.testbank.payment.model.PaymentInfo;
import com.testbank.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    
    public PaymentServiceImpl(@Autowired PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void processPayment(PaymentInfo paymentInfo) {
        // Add business logic if needed
        paymentRepository.save(paymentInfo);
    }
}
