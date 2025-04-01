package com.ivamly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Address {

    /**
     * Unique identifier for the address.
     */
    @Id
    private UUID id;

    /**
     * Country of the address.
     */
    private String country;

    /**
     * City of the address.
     */
    private String city;

    /**
     * Street of the address.
     */
    private String street;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
