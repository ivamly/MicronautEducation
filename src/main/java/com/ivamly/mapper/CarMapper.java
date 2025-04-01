package com.ivamly.mapper;

import com.ivamly.dto.request.CreateCarRequest;
import com.ivamly.dto.response.CarResponse;
import com.ivamly.model.Car;
import jakarta.inject.Singleton;

@Singleton
public class CarMapper {

    public Car map(CreateCarRequest source) {
        Car car = new Car();

        car.setBrand(source.getBrand());
        car.setModel(source.getModel());

        return car;
    }

    public CarResponse map(Car source) {
        CarResponse carResponse = new CarResponse();

        carResponse.setId(String.valueOf(source.getId()));
        carResponse.setBrand(source.getBrand());
        carResponse.setModel(source.getModel());

        return carResponse;
    }
}
