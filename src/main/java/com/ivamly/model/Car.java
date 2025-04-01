package com.ivamly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Car {

    /**
     * Unique identifier for the car.
     */
    @Id
    private UUID id;

    /**
     * Brand of the car.
     */
    private String brand;

    /**
     * Model of the car.
     */
    private String model;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
}
