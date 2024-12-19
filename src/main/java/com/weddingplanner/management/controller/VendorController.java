package com.weddingplanner.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weddingplanner.management.model.Vendor;
import com.weddingplanner.management.serviceImpl.VendorServiceImpl;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorServiceImpl vendorService;

    // Create a new Vendor
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.saveVendor(vendor);
    }

    // Get a vendor by ID
    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }

    // Update the availability of a vendor
    @PutMapping("/{id}/updateAvailability")
    public Vendor updateVendorAvailability(@PathVariable Long id, @RequestParam boolean available) {
        return vendorService.updateVendorAvailability(id, available);
    }

    // Get all vendors
    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }
}

