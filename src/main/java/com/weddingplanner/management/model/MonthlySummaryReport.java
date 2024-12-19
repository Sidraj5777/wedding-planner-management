package com.weddingplanner.management.model;

import java.util.List;
import java.util.Map;

public class MonthlySummaryReport {
    private long totalClients;
    private long totalEvents;
    private Map<String, Long> eventsByStatus;
    private List<VendorSummary> topVendors;
    private double totalRevenue;
	public long getTotalClients() {
		return totalClients;
	}
	public void setTotalClients(long totalClients) {
		this.totalClients = totalClients;
	}
	public long getTotalEvents() {
		return totalEvents;
	}
	public void setTotalEvents(long totalEvents) {
		this.totalEvents = totalEvents;
	}
	public Map<String, Long> getEventsByStatus() {
		return eventsByStatus;
	}
	public void setEventsByStatus(Map<String, Long> eventsByStatus) {
		this.eventsByStatus = eventsByStatus;
	}
	public List<VendorSummary> getTopVendors() {
		return topVendors;
	}
	public void setTopVendors(List<VendorSummary> topVendors) {
		this.topVendors = topVendors;
	}
	public double getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	public MonthlySummaryReport(long totalClients, long totalEvents, Map<String, Long> eventsByStatus,
			List<VendorSummary> topVendors, double totalRevenue) {
		super();
		this.totalClients = totalClients;
		this.totalEvents = totalEvents;
		this.eventsByStatus = eventsByStatus;
		this.topVendors = topVendors;
		this.totalRevenue = totalRevenue;
	}
	public MonthlySummaryReport() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}

