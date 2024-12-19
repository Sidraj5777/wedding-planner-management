
package com.weddingplanner.management.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weddingplanner.management.customexception.ResourceNotFoundException;
import com.weddingplanner.management.model.Client;
import com.weddingplanner.management.model.Payment;
import com.weddingplanner.management.model.PaymentStatus;
import com.weddingplanner.management.repository.ClientRepository;
import com.weddingplanner.management.repository.PaymentRepository;
import com.weddingplanner.management.service.PaymentService;

import ch.qos.logback.core.status.Status;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Payment recordPayment(Long clientId, Double amount) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with ID: " + clientId));

        // Create a new payment record
        Payment payment = new Payment();
        payment.setClient(client);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDate.now());
        payment.setStatus(PaymentStatus.PENDING);  // Initially, set payment status to PENDING

        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getPaymentsByStatus(PaymentStatus status) {
        return paymentRepository.findByStatus(status);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with ID: " + paymentId));
    }

//	@Override
//	public List<Payment> getPaymentsByStatus(Status status) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}

