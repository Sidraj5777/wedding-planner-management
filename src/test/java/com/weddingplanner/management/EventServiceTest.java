package com.weddingplanner.management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import com.weddingplanner.management.repository.ClientRepository;
import com.weddingplanner.management.repository.EventRepository;
import com.weddingplanner.management.serviceImpl.EventServiceImpl;

@SpringBootTest
public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    private Event event;
    private Client client;

    @BeforeEach
    public void setUp() {
        // Set up a sample client
        client = new Client();
        client.setId(3L);
        client.setBudget(5000.0);

        // Set up a sample event
        event = new Event();
        event.setId(4L);
        event.setName("Wedding new Ceremony");
        event.setEventDate(LocalDate.of(2025, 7, 30));
        event.setStatus(EventStatus.UPCOMING);
        event.setTotalCost(1500.0);
        event.setClient(client);
    }

    @Test
    public void testCreateEvent() {
        // Mock client lookup and event saving
        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        Mockito.when(eventRepository.save(Mockito.any(Event.class))).thenReturn(event);

        // Call the service method to create the event
        Event createdEvent = eventService.createEvent(event, 1L);

        // Verify the created event details
        assertNotNull(createdEvent);
        assertEquals("Wedding new Ceremony", createdEvent.getName());
        assertEquals(LocalDate.of(2025, 7, 30), createdEvent.getEventDate());
        assertEquals(EventStatus.UPCOMING, createdEvent.getStatus());
        assertEquals(1500.0, createdEvent.getTotalCost());
        assertEquals(3L, createdEvent.getClient().getId());
    }

    @Test
    public void testGetEventById() {
        // Mock the repository to return the event for id 4
        Mockito.when(eventRepository.findById(1L)).thenReturn(Optional.of(event));

        // Call the service method to fetch the event by id
        Event fetchedEvent = eventService.getEventById(1L);

        // Verify the fetched event details
        assertNotNull(fetchedEvent);
//        assertEquals(1L, fetchedEvent.getId());
        assertEquals("Wedding new Ceremony", fetchedEvent.getName());
        assertEquals(LocalDate.of(2025, 7, 30), fetchedEvent.getEventDate());
        assertEquals(EventStatus.UPCOMING, fetchedEvent.getStatus());
    }

    @Test
    public void testGetAllEventsByStatus() {
        // Mock repository to return a list of events with status "UPCOMING"
        Mockito.when(eventRepository.findByStatus(EventStatus.UPCOMING)).thenReturn(Arrays.asList(event));

        // Call the service method to get all events with status "UPCOMING"
//        List<Event> events = eventService.getAllEventsByStatus(EventStatus.UPCOMING);

        // Verify the list contains the expected events
//        assertNotNull(events);
//        assertEquals(1, events.size());
//        assertEquals("Wedding new Ceremony", events.get(0).getName());
//        assertEquals("UPCOMING", events.get(0).getStatus());
    }

    @Test
    public void testEventDateValidation() {
        LocalDate pastDate = LocalDate.now().minusDays(1);
        boolean isValid = eventService.validateEventDate(pastDate);
        assertFalse(isValid);
    }

    @Test
    public void testEventBudgetValidation() {
        Event invalidEvent = new Event();
        invalidEvent.setTotalCost(1000.0);

        Mockito.when(eventRepository.findById(1L)).thenReturn(Optional.of(invalidEvent));

//        boolean isValid = eventService.validateEventBudget(1L, 1000.0);
//        assertTrue(isValid);
    }
}
