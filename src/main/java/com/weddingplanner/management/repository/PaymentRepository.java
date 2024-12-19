package com.weddingplanner.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weddingplanner.management.model.Payment;
import com.weddingplanner.management.model.PaymentStatus;

import ch.qos.logback.core.status.Status;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStatus(PaymentStatus status);
}

