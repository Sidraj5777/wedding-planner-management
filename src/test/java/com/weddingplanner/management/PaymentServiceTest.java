package com.weddingplanner.management;



import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.weddingplanner.management.model.Client;
import com.weddingplanner.management.model.Payment;
import com.weddingplanner.management.model.PaymentStatus;
import com.weddingplanner.management.repository.ClientRepository;
import com.weddingplanner.management.repository.PaymentRepository;
import com.weddingplanner.management.serviceImpl.PaymentServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Test
    public void testRecordPayment() {
        Client client = new Client();
        client.setId(1L);
        client.setBudget(1000.0);

        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Payment payment = paymentService.recordPayment(1L, 500.0);
//        assertNotNull(payment);
//        assertEquals(500.0, payment.getAmount());
//        assertEquals(PaymentStatus.PENDING, payment.getStatus());
    }

    @Test
    public void testGetPaymentsByStatus() {
        List<Payment> payments = paymentService.getPaymentsByStatus(PaymentStatus.PENDING);
        assertNotNull(payments);
    }

    @Test
    public void testGetPaymentById() {
        Payment payment = new Payment();
        payment.setId(1L);
        Mockito.when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));

        Payment foundPayment = paymentService.getPaymentById(1L);
        assertNotNull(foundPayment);
//        assertEquals(1L, foundPayment.getId());
    }
}

