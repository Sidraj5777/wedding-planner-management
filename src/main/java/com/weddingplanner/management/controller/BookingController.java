package com.weddingplanner.management.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weddingplanner.management.model.Booking;
import com.weddingplanner.management.model.Vendor;
import com.weddingplanner.management.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> bookVendorForEvent(@RequestParam Long eventId, @RequestParam Long vendorId) {
        Booking booking = bookingService.bookVendorForEvent(eventId, vendorId);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok("Booking cancelled successfully.");
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<?> getBookingsForEvent(@PathVariable Long eventId) {
        List<Booking> bookings = bookingService.getBookingsForEvent(eventId);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/available-vendors")
    public ResponseEntity<?> getAvailableVendorsForEvent(
            @RequestParam Long eventId,
            @RequestParam LocalDate eventDate,
            @RequestParam String serviceType) {
    	
    	LocalDateTime currentTime = LocalDateTime.now();
    	
    	boolean flag = false;

        // Example: Target time (future or past)
        LocalDateTime targetTime = LocalDateTime.parse(eventDate.toString());
        
        if (targetTime.isAfter(currentTime)) {
        	 flag = false;
        }else if (targetTime.isBefore(currentTime)) {
        	flag = true;
        }
    	
        List<Vendor> vendors = bookingService.getAvailableVendorsForEvent(eventId, flag , serviceType);
        return ResponseEntity.ok(vendors);
    }
}
