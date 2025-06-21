package com.example.VehicleRental.service.impl;


import com.example.VehicleRental.entity.Booking;
import com.example.VehicleRental.repository.BookingRepository;
import com.example.VehicleRental.service.api.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No Booking found for Id: "+id));
    }

    @Override
    public List<Booking> getAllBookingByUser(Long userId) {
        return  bookingRepository.findByUserId(userId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No Booking found for Id: "+id));

        existingBooking.setUserId(booking.getUserId());
        existingBooking.setVehicleId(booking.getVehicleId());
        existingBooking.setToTime(booking.getToTime());
        existingBooking.setStatus(booking.getStatus());
        existingBooking.setFromTime(booking.getFromTime());

        return bookingRepository.save(existingBooking);
    }

    @Override
    public void cancelBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
