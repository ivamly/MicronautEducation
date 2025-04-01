package com.ivamly.dto.request;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

@Serdeable
public class CreateCitizenRequest {

    /**
     * Name of the citizen.
     */
    @NotEmpty
    private String name;

    /**
     * Age of the citizen.
     */
    @PositiveOrZero
    private Integer age;

    /**
     * Series of the identification document.
     */
    @NotEmpty
    private String series;

    /**
     * Number of the identification document.
     */
    @NotEmpty
    private String number;

    /**
     * Country of residence.
     */
    @NotEmpty
    private String country;

    /**
     * City of residence.
     */
    @NotEmpty
    private String city;

    /**
     * Street of residence.
     */
    @NotEmpty
    private String street;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
