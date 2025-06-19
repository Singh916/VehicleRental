package com.example.VehicleRental.controller;


import com.example.VehicleRental.entity.User;
import com.example.VehicleRental.entity.Vehicle;
import com.example.VehicleRental.service.api.UserService;
import com.example.VehicleRental.service.api.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

        @Autowired
        private VehicleService vehicleService;

        @PostMapping()
        public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
            return vehicleService.addVehicle(vehicle);
        }

        @GetMapping("/{id}")
        public Vehicle getVehicleById(@PathVariable Long id) {
            return vehicleService.getVehicleById(id);
        }

        @GetMapping("/available")
        public List<Vehicle> getAvailableByType(@RequestParam String type) {
            return vehicleService.getAvailableByType(type);
        }

        @GetMapping()
        public List<Vehicle> getAllVehicle() {
            return vehicleService.getAllVehicles();
        }

        @PutMapping("/{id}")
        public Vehicle updateVehicle(@PathVariable Long id,@RequestBody Vehicle vehicle) {
            return vehicleService.updateVehicle(id,vehicle);
        }

        @DeleteMapping("/{id}")
        public void deleteVehicle(@PathVariable Long id) {
            vehicleService.deleteVehicle(id);
        }

}
