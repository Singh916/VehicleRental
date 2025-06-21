package com.example.VehicleRental.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private String brand;
    private String model;
    private String location;

    private boolean IsAvailalble;

    public Vehicle() {}

    public Vehicle(int id, String type, String brand, String model, String location, boolean isAvailalble) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.location = location;
        this.IsAvailalble = isAvailalble;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailalble() {
        return IsAvailalble;
    }

    public void setAvailalble(boolean availalble) {
        IsAvailalble = availalble;
    }

}
