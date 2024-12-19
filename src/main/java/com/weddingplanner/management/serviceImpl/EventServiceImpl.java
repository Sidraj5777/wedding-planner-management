package com.weddingplanner.management.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weddingplanner.management.customexception.InvalidEventDateException;
import com.weddingplanner.management.customexception.ResourceNotFoundException;
import com.weddingplanner.management.model.Client;
import com.weddingplanner.management.model.Event;
import com.weddingplanner.management.model.EventStatus;
import com.weddingplanner.management.repository.BookingRepository;
import com.weddingplanner.management.repository.ClientRepository;
import com.weddingplanner.management.repository.EventRepository;
import com.weddingplanner.management.service.EventService;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Event createEvent(Event event, Long clientId) {
        // Retrieve client and associate event with client
    	
    	ClientServiceImpl.pastDateChecker(event.getEventDate());
    	
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with ID: " + clientId));
        
        event.setClient(client);
        
        // Validate event date (check if in the past)
        if (!validateEventDate(event.getEventDate())) {
            throw new InvalidEventDateException("Event date cannot be in the past.");
        }

//        // Validate budget
//        if (!validateEventBudget(event.getId(), event.getTotalCost())) {
//            throw new InvalidBudgetException("Event cost exceeds client's budget.");
//        }

        return eventRepository.save(event);
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + id));
    }

    @Override
    public List<Event> getAllEvents(String status) {
        if (status != null) {
            return eventRepository.findByStatus(EventStatus.valueOf(status.toUpperCase()));
        }
        return eventRepository.findAll();
    }

    @Override
    public boolean validateEventDate(LocalDate eventDate) {
        return !eventDate.isBefore(LocalDate.now());
    }

    @Override
    public boolean validateEventBudget(Long eventId, Double totalCost) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + eventId));
        
        Client client = event.getClient();
        return client.getBudget() >= totalCost;
    }
}

