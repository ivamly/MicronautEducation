package com.ivamly.dto;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class GetHouseResponse {

    private String id;

    private Integer floor;

    private AddressDto address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
