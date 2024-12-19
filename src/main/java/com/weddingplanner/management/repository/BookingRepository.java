package com.weddingplanner.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weddingplanner.management.model.Booking;
import com.weddingplanner.management.model.Event;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByEvent(Event event);
}