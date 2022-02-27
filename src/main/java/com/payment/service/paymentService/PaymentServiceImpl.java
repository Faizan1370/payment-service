package com.payment.service.paymentService;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.payment.service.entity.Payment;
import com.payment.service.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URI;

    @Override
    public void savePayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        paymentRepo.save(payment);

    }

    public String paymentProcessing() {
        return new Random().nextBoolean() ? "success" : "false";
    }

}
