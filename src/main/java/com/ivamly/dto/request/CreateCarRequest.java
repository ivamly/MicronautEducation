package com.ivamly.dto.request;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotEmpty;

@Serdeable
public class CreateCarRequest {

    /**
     * Brand of the car.
     */
    @NotEmpty
    private String brand;

    /**
     * Model of the car.
     */
    @NotEmpty
    private String model;

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
