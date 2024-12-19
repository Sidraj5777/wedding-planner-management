package com.weddingplanner.management.service;

import java.util.List;

import com.weddingplanner.management.model.Payment;
import com.weddingplanner.management.model.PaymentStatus;

import ch.qos.logback.core.status.Status;

public interface PaymentService {

	
	 Payment recordPayment(Long clientId, Double amount);

	    List<Payment> getPaymentsByStatus(PaymentStatus status);

	    Payment getPaymentById(Long paymentId);
}
