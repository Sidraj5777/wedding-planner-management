package com.weddingplanner.management.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weddingplanner.management.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByWeddingDate(LocalDate weddingDate);

    List<Client> findByBudgetBetween(Double minBudget, Double maxBudget);
}
