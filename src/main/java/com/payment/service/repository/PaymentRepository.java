package com.payment.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payment.service.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
