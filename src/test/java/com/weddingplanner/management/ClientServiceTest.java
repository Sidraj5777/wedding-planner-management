package com.weddingplanner.management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.weddingplanner.management.model.Client;
import com.weddingplanner.management.model.Event;
import com.weddingplanner.management.model.EventStatus;
import com.weddingplanner.management.model.Payment;
import com.weddingplanner.management.model.PaymentStatus;
import com.weddingplanner.management.repository.ClientRepository;
import com.weddingplanner.management.serviceImpl.ClientServiceImpl;

@SpringBootTest
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    private Client client;
    
    LocalDate currentdate = LocalDate.now();

    @BeforeEach
    public void setUp() {
        // Create a new client instance for testing
    	
    	LocalDate currentdate = LocalDate.now();
    	
        client = new Client();
        client.setName("Sid Raj");
        client.setBudget(90000.0);
        client.setContactNumber("8218387777");
        client.setWeddingDate(currentdate);

        // Create events and payments
        Event event = new Event();
        event.setName("Wedding Ceremony");
        event.setEventDate(currentdate);
       
		event.setStatus(EventStatus.UPCOMING);
        event.setTotalCost(25000.0);
        event.setClient(client);

        client.setEvents(Arrays.asList(event));

        Payment payment = new Payment();
        
		payment.setStatus(PaymentStatus.PENDING);
        payment.setPaymentDate(currentdate);
        payment.setClient(client);

        client.setPayments(Arrays.asList(payment));
    }

    @Test
    public void testCreateClient() {
        Mockito.when(clientRepository.save(Mockito.any(Client.class))).thenReturn(client);

        // Call the service method to create the client
        Client createdClient = clientService.createClient(client);

        assertNotNull(createdClient);
        assertEquals("Sid Raj", createdClient.getName());
        assertEquals(90000.0, createdClient.getBudget());
        assertEquals("8218387777", createdClient.getContactNumber());
//        assertEquals(currentdate, createdClient);
    }

//    @Test
//    public void testGetAllClients() {
//        // Mock the repository method to return a list of clients
//        Mockito.when(clientRepository.findAll()).thenReturn(Arrays.asList(client));
//
//        // Call the service method to fetch all clients
//        List<Client> clients = clientService.getAllClients();
//
//        assertNotNull(clients);
//        assertEquals(1, clients.size());
//        assertEquals("Sid Raj", clients.get(0).getName());
//    }

    @Test
    public void testGetClientById() {
        // Mock the repository method to return the client by id
        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        // Call the service method to fetch the client by id
        Client foundClient = clientService.getClientById(1L);

        assertNotNull(foundClient);
//        assertEquals(1L, foundClient.getId());
        assertEquals("Sid Raj", foundClient.getName());
    }
}
