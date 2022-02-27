package com.payment.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.service.entity.Payment;
import com.payment.service.paymentService.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping("/order-payment")
    public ResponseEntity<?> savePayment(@RequestBody Payment payment) {
        logger.info("payment request :" + payment);
        paymentService.savePayment(payment);
        return ResponseEntity.ok(payment);

    }

}
