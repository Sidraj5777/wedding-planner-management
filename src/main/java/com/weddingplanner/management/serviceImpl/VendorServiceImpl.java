package com.weddingplanner.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weddingplanner.management.model.Vendor;
import com.weddingplanner.management.repository.VendorRepository;

@Service
public class VendorServiceImpl {

    @Autowired
    private VendorRepository vendorRepository;

    // Save a new vendor
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // Get a vendor by ID
    public Vendor getVendorById(Long id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if (vendor.isPresent()) {
            return vendor.get();
        } else {
            throw new RuntimeException("Vendor not found for id: " + id);
        }
    }

    // Get all vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // Update availability of a vendor
    public Vendor updateVendorAvailability(Long id, boolean available) {
        Vendor vendor = getVendorById(id);  // Retrieve the vendor by ID
        vendor.updateAvailability(available);  // Update availability status
        return vendorRepository.save(vendor);  // Save the updated vendor
    }

    // Find vendors by service type
    public List<Vendor> findVendorsByServiceType(String serviceType) {
        return vendorRepository.findByServiceType(serviceType);
    }

    // Find vendors by availability status
    public Vendor findVendorsByAvailability(Long id) {
    	Vendor vendor = getVendorById(id);
        return vendor;
    }

    // Find vendors by service type and availability
    public List<Vendor> findVendorsByServiceTypeAndAvailability(String serviceType, boolean available) {
        return vendorRepository.findByServiceTypeAndAvailable(serviceType, available);
    }
}

