package com.weddingplanner.management.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weddingplanner.management.customexception.PastDateException;
import com.weddingplanner.management.customexception.ResourceNotFoundException;
import com.weddingplanner.management.model.Client;
import com.weddingplanner.management.repository.ClientRepository;
import com.weddingplanner.management.service.ClientService;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
      
    	pastDateChecker(client.getWeddingDate());
    	
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        // Fetch client or throw an exception if not found
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with ID: " + id));
    }

    @Override
    public List<Client> getAllClients(LocalDate weddingDate, Double minBudget, Double maxBudget) {
        // Optional filtering based on parameters
        if (weddingDate != null) {
            return clientRepository.findByWeddingDate(weddingDate);
        } else if (minBudget != null && maxBudget != null) {
            return clientRepository.findByBudgetBetween(minBudget, maxBudget);
        }
        return clientRepository.findAll();
    }
    
    
    public static void pastDateChecker(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
    	
    	if (date.isAfter(currentDate)) {
            System.out.println("The wedding date is in the future.");
        }else if (date.isEqual(currentDate)) {
        	System.out.println("The wedding date is currentDate.");
        }else {
            System.out.println("The wedding date is in the past.");
            throw new PastDateException("Wedding date cannot be in the past.");
        }
    	
    }
    
}

