package com.example.VehicleRental.service.impl;

import com.example.VehicleRental.entity.Vehicle;
import com.example.VehicleRental.repository.VehicleRepository;
import com.example.VehicleRental.service.api.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: "+id));
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> getAvailableByType(String type) {
        return vehicleRepository.findByTypeAndAvailableTrue(type);
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: "+id));

        existingVehicle.setBrand(vehicle.getBrand());
        existingVehicle.setLocation(vehicle.getLocation());
        existingVehicle.setType(vehicle.getType());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setAvailalble(vehicle.isAvailalble());

        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
