package com.weddingplanner.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weddingplanner.management.model.Event;
import com.weddingplanner.management.model.EventStatus;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByStatus(EventStatus status);
}