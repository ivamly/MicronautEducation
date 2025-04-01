package com.ivamly.dto.request;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.PositiveOrZero;

@Serdeable
public class UpdateHouseRequest {

    @PositiveOrZero
    private Integer floor;

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
