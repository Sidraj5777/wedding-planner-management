package com.weddingplanner.management.service;

import java.time.LocalDate;
import java.util.List;

import com.weddingplanner.management.model.Event;

public interface EventService {

	Event createEvent(Event event, Long clientId);

    Event getEventById(Long id);

    List<Event> getAllEvents(String status);

    boolean validateEventDate(LocalDate eventDate);

    boolean validateEventBudget(Long eventId, Double totalCost);
	
}
