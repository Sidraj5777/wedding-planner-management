package com.weddingplanner.management.model;

public class VendorSummary {

	
	private String vendorName;
    private long numberOfBookings;
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public long getNumberOfBookings() {
		return numberOfBookings;
	}
	public void setNumberOfBookings(long numberOfBookings) {
		this.numberOfBookings = numberOfBookings;
	}
	public VendorSummary(String vendorName, long numberOfBookings) {
		super();
		this.vendorName = vendorName;
		this.numberOfBookings = numberOfBookings;
	}
	public VendorSummary() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
}
