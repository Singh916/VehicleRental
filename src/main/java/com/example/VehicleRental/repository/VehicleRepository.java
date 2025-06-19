package com.example.VehicleRental.repository;

import com.example.VehicleRental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    List<Vehicle> findByTypeAndAvailableTrue(String type);
}
