//package com.weddingplanner.management;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.weddingplanner.management.model.Booking;
//import com.weddingplanner.management.model.Event;
//import com.weddingplanner.management.model.Vendor;
//import com.weddingplanner.management.repository.BookingRepository;
//import com.weddingplanner.management.repository.EventRepository;
//import com.weddingplanner.management.repository.VendorRepository;
//import com.weddingplanner.management.serviceImpl.BookingServiceImpl;
//import com.weddingplanner.management.serviceImpl.VendorServiceImpl;
//
//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
//public class BookingServiceTest {
//
//    @Mock
//    private BookingRepository bookingRepository;
//
//    @Mock
//    private VendorRepository vendorRepository;
//
//    @Mock
//    private EventRepository eventRepository;
//
//    @Mock
//    private VendorServiceImpl vendorService;
//
//    @InjectMocks
//    private BookingServiceImpl bookingService;
//
//    @Test
//    public void testBookVendorForEvent() {
//        Event event = new Event();
//        event.setId(1L);
//        event.setEventDate(LocalDate.now().plusDays(1));
//
//        Vendor vendor = new Vendor();
//        vendor.setId(1L);
//        vendor.setServiceType("Catering");
//
//        Mockito.when(eventRepository.findById(1L)).thenReturn(Optional.of(event));
//        Mockito.when(vendorRepository.findById(1L)).thenReturn(Optional.of(vendor));
////        Mockito.when(vendorService.isVendorAvailable(1L, event.getEventDate())).thenReturn(true);
//
//        Booking booking = bookingService.bookVendorForEvent(1L, 1L);
//        assertNotNull(booking);
//        assertEquals(vendor, booking.getVendor());
//        assertEquals(event, booking.getEvent());
//    }
//
//    @Test
//    public void testCancelBooking() {
//        Booking booking = new Booking();
//        booking.setId(1L);
//
//        Mockito.when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
//
//        bookingService.cancelBooking(1L);
//        Mockito.verify(bookingRepository, Mockito.times(1)).delete(booking);
//    }
//
//    @Test
//    public void testGetBookingsForEvent() {
//        Event event = new Event();
//        event.setId(1L);
//
//        Mockito.when(eventRepository.findById(1L)).thenReturn(Optional.of(event));
//        List<Booking> bookings = bookingService.getBookingsForEvent(1L);
//        assertNotNull(bookings);
//    }
//}
