//package com.weddingplanner.management.service;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.weddingplanner.management.model.Event;
//import com.weddingplanner.management.model.MonthlySummaryReport;
//import com.weddingplanner.management.model.VendorSummary;
//import com.weddingplanner.management.repository.BookingRepository;
//import com.weddingplanner.management.repository.ClientRepository;
//import com.weddingplanner.management.repository.EventRepository;
//import com.weddingplanner.management.repository.PaymentRepository;
//
//@Service
//public class ReportService {
//
//    @Autowired
//    private ClientRepository clientRepository;
//
//    @Autowired
//    private EventRepository eventRepository;
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    public MonthlySummaryReport generateMonthlyReport() {
//        // Get the first and last dates of the previous month
//        LocalDate firstOfLastMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1);
//        LocalDate lastOfLastMonth = firstOfLastMonth.withDayOfMonth(firstOfLastMonth.lengthOfMonth());
//
//        // Get total clients registered in the previous month
//        long totalClients = clientRepository.countByRegistrationDateBetween(firstOfLastMonth, lastOfLastMonth);
//
//        // Get total events organized in the previous month
//        List<Event> events = eventRepository.findByEventDateBetween(firstOfLastMonth, lastOfLastMonth);
//        long totalEvents = events.size();
//
//        // Categorize events by status
//        Map<String, Long> eventsByStatus = events.stream()
//            .collect(Collectors.groupingBy(Event::getStatus, Collectors.counting()));
//
//        // Get top 3 most popular vendors based on bookings
//        List<VendorSummary> topVendors = bookingRepository.findTop3VendorsByBookingCount(firstOfLastMonth, lastOfLastMonth);
//
//        // Get total revenue for the previous month
//        double totalRevenue = paymentRepository.sumPaymentsByDateRange(firstOfLastMonth, lastOfLastMonth);
//
//        // Return the monthly summary report
//        MonthlySummaryReport report = new MonthlySummaryReport();
//        report.setTotalClients(totalClients);
//        report.setTotalEvents(totalEvents);
//        report.setEventsByStatus(eventsByStatus);
//        report.setTopVendors(topVendors);
//        report.setTotalRevenue(totalRevenue);
//
//        return report;
//    }
//}
//
