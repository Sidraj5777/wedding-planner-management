package com.weddingplanner.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weddingplanner.management.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

    // Custom query to find vendors by their service type
    List<Vendor> findByServiceType(String serviceType);

    // Custom query to find vendors by availability
    List<Vendor> findByAvailable(boolean available);

    // Custom query to find vendors by service type and availability
    List<Vendor> findByServiceTypeAndAvailable(String serviceType, boolean available);
}
