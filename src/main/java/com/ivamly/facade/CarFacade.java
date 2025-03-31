package com.ivamly.facade;

import com.ivamly.dto.CreateCarRequest;
import com.ivamly.dto.GetCarResponse;
import com.ivamly.model.Car;
import com.ivamly.service.CarService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class CarFacade {

    @Inject
    private CarService carService;

    public GetCarResponse get(String id) {
        Car carEntity = carService.get(UUID.fromString(id));

        if (carEntity == null) {
            throw new RuntimeException("Car not found");
        }

        GetCarResponse getCarResponse = new GetCarResponse();

        getCarResponse.setId(String.valueOf(carEntity.getId()));
        getCarResponse.setBrand(carEntity.getBrand());
        getCarResponse.setModel(carEntity.getModel());

        return getCarResponse;
    }

    public GetCarResponse create(CreateCarRequest car) {
        Car carEntity = new Car();

        carEntity.setId(UUID.randomUUID());
        carEntity.setBrand(car.getBrand());
        carEntity.setModel(car.getModel());

        carService.save(carEntity);

        GetCarResponse getCarResponse = new GetCarResponse();

        getCarResponse.setId(String.valueOf(carEntity.getId()));
        getCarResponse.setBrand(carEntity.getBrand());
        getCarResponse.setModel(carEntity.getModel());

        return getCarResponse;
    }
}
