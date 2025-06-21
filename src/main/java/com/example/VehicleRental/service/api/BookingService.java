package com.example.VehicleRental.service.api;

import com.example.VehicleRental.entity.Booking;
import com.example.VehicleRental.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    Booking createBooking(Booking booking);

    Booking getBookingById(Long id);

    List<Booking> getAllBookingByUser(Long userId);

    List<Booking> getAllBookings();

    Booking updateBooking(Long id,Booking booking);

    void cancelBooking(Long id);

}
