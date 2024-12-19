package com.weddingplanner.management.service;

import java.time.LocalDate;
import java.util.List;

import com.weddingplanner.management.model.Client;

public interface ClientService {
	
    Client createClient(Client client);

    Client getClientById(Long id);

    List<Client> getAllClients(LocalDate weddingDate, Double minBudget, Double maxBudget);


}
