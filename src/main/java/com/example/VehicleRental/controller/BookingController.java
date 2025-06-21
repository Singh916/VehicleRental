package com.example.VehicleRental.controller;


import com.example.VehicleRental.entity.Booking;
import com.example.VehicleRental.service.api.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

   @Autowired
   private BookingService bookingService;

   @PostMapping
   public Booking createBooking(@RequestBody  Booking booking) {
       return bookingService.createBooking(booking);
    }

   @GetMapping("/user/{userId}")
    List<Booking> getAllBookingsByUser(@PathVariable Long userId) {
       return bookingService.getAllBookingByUser(userId);
    }

    @GetMapping("/{bookingId}")
    Booking getBookingById(@RequestParam Long bookingId) {
       return bookingService.getBookingById(bookingId);
    }

    @GetMapping
    List<Booking> getAllBookings() {
       return bookingService.getAllBookings();
    }

    @PutMapping("/{bookingId}")
    Booking updateBooking(@RequestParam Long bookingId, @RequestBody Booking booking) {
       return bookingService.updateBooking(bookingId, booking);
    }

    @DeleteMapping("/{bookingId}")
    void deleteBooking(@RequestParam Long bookingId) {
       bookingService.cancelBooking(bookingId);
    }

}
