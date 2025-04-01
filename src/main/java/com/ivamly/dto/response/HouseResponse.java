package com.ivamly.dto.response;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class HouseResponse {

    /**
     * Identifier.
     */
    private String id;

    /**
     * Floor number.
     */
    private Integer floor;

    /**
     * Address information {@link AddressResponse}.
     */
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
