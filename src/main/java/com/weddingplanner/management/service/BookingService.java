package com.weddingplanner.management.service;

import java.time.LocalDate;
import java.util.List;

import com.weddingplanner.management.model.Booking;
import com.weddingplanner.management.model.Vendor;

public interface BookingService {

	Booking bookVendorForEvent(Long eventId, Long vendorId);

    void cancelBooking(Long bookingId);

    List<Booking> getBookingsForEvent(Long eventId);

    List<Vendor> getAvailableVendorsForEvent(Long eventId, boolean eventDate, String serviceType);
	
}
