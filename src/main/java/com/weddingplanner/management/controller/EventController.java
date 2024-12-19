package com.weddingplanner.management.controller;

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

import com.weddingplanner.management.model.Event;
import com.weddingplanner.management.serviceImpl.EventServiceImpl;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event, event.getClientId());
        return ResponseEntity.ok(createdEvent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @GetMapping
    public ResponseEntity<?> getAllEvents(@RequestParam(required = false) String status) {
        List<Event> events = eventService.getAllEvents(status);
        return ResponseEntity.ok(events);
    }
}
