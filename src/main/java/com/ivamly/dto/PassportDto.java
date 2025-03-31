package com.ivamly.dto;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class PassportDto {

    private String id;

    private String series;

    private String number;

    private AddressDto address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
