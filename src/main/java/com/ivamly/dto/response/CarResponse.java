package com.ivamly.dto.response;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class CarResponse {

    /**
     * Identifier.
     */
    private String id;

    /**
     * Brand of the car.
     */
    private String brand;

    /**
     * Model of the car.
     */
    private String model;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
