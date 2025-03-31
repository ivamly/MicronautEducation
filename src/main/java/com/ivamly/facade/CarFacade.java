package com.ivamly.facade;

import com.ivamly.dto.CreateCarRequest;
import com.ivamly.dto.GetCarResponse;
import com.ivamly.model.Car;
import com.ivamly.service.CarService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Singleton
public class CarFacade {

    @Inject
    private CarService carService;

    public Mono<GetCarResponse> get(String id) {
        return carService.get(UUID.fromString(id))
                .map(this::convert);
    }

    public Mono<GetCarResponse> create(CreateCarRequest car) {
        Car carEntity = new Car();

        carEntity.setId(UUID.randomUUID());
        carEntity.setBrand(car.getBrand());
        carEntity.setModel(car.getModel());

        carService.save(carEntity);

        return Mono.just(convert(carEntity));
    }

    private GetCarResponse convert(Car car) {

        if (car == null) {
            throw new RuntimeException("Car not found");
        }

        GetCarResponse getCarResponse = new GetCarResponse();

        getCarResponse.setId(String.valueOf(car.getId()));
        getCarResponse.setBrand(car.getBrand());
        getCarResponse.setModel(car.getModel());

        return getCarResponse;
    }
}
