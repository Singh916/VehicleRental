package com.example.VehicleRental.repository;

import com.example.VehicleRental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findByUserId(Long userId);

    List<Booking>  findByVehicleId(Long vehicleId);

    List<Booking> findByUserIdAndStatusBooked(Long userId);

}
