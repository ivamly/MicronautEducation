package com.ivamly.dto.response;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class HouseResponse {

    private String id;

    private Integer floor;

    private AddressResponse address;

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

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }
}
