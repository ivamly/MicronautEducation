package com.ivamly.dto.request;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

@Serdeable
public class CreateHouseRequest {

    /**
     * Floor number of the house.
     */
    @PositiveOrZero
    private Integer floor;

    /**
     * Country where the house is located.
     */
    @NotEmpty
    private String country;

    /**
     * City where the house is located.
     */
    @NotEmpty
    private String city;

    /**
     * Street where the house is located.
     */
    @NotEmpty
    private String street;

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
