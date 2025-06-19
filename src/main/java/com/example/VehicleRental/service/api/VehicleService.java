package com.example.VehicleRental.service.api;

import com.example.VehicleRental.entity.User;
import com.example.VehicleRental.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VehicleService {

    Vehicle addVehicle(Vehicle vehicle);

    Vehicle getVehicleById(Long id);

    List<Vehicle> getAllVehicles();

    List<Vehicle> getAvailableByType(String type);

    Vehicle updateVehicle(Long id,Vehicle vehicle);

    void deleteVehicle(Long id);

}
