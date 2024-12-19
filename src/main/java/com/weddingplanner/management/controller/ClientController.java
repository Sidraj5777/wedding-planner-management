package com.weddingplanner.management.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weddingplanner.management.model.Client;
import com.weddingplanner.management.model.Event;
import com.weddingplanner.management.model.Payment;
import com.weddingplanner.management.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody Client client) {
    	
    	if (client.getEvents() != null) {
            for (Event event : client.getEvents()) {
                event.setClient(client);
            }
        }
    	
    	 if (client.getPayments() != null) {
    	        for (Payment payment : client.getPayments()) {
    	            payment.setClient(client);
    	        }
    	    }
    	
    	 System.out.println("client info -- > "+ client);
    	 
        Client createdClient = clientService.createClient(client);
        return ResponseEntity.ok(createdClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<?> getAllClients(
            @RequestParam(required = false) LocalDate weddingDate,
            @RequestParam(required = false) Double minBudget,
            @RequestParam(required = false) Double maxBudget) {
        List<Client> clients = clientService.getAllClients(weddingDate, minBudget, maxBudget);
        return ResponseEntity.ok(clients);
    }
}
