package com.weddingplanner.management.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weddingplanner.management.customexception.ResourceNotFoundException;
import com.weddingplanner.management.customexception.VendorNotAvailableException;
import com.weddingplanner.management.model.Booking;
import com.weddingplanner.management.model.Event;
import com.weddingplanner.management.model.Vendor;
import com.weddingplanner.management.repository.BookingRepository;
import com.weddingplanner.management.repository.EventRepository;
import com.weddingplanner.management.repository.VendorRepository;
import com.weddingplanner.management.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private VendorRepository vendorRepository;	

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private VendorServiceImpl vendorService;  // For checking vendor availability

    @Override
    public Booking bookVendorForEvent(Long eventId, Long vendorId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + eventId));

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found with ID: " + vendorId));

        // Check if the vendor is available on the event date
        if (vendorService.findVendorsByAvailability(vendorId)==null) {
            throw new VendorNotAvailableException("Vendor is not available for the selected event date.");
        }

        // Create a booking for the vendor and the event
        Booking booking = new Booking();
        booking.setEvent(event);
        booking.setVendor(vendor);
        booking.setBookingDate(LocalDate.now());

        return bookingRepository.save(booking);
    }

    @Override
    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));

        bookingRepository.delete(booking);
    }

    @Override
    public List<Booking> getBookingsForEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + eventId));

        return bookingRepository.findByEvent(event);
    }

    @Override
    public List<Vendor> getAvailableVendorsForEvent(Long eventId, boolean avilaibility, String serviceType) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + eventId));

        // Call the VendorService to get the list of available vendors for the service type and date
        return vendorService.findVendorsByServiceTypeAndAvailability(serviceType,avilaibility );
    }
}
