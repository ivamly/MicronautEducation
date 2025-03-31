package com.ivamly.service;

import com.ivamly.model.Car;
import com.ivamly.repository.CarRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Singleton
public class CarService {

    @Inject
    private CarRepository carRepository;

    public Mono<Car> get(UUID id) {
        return carRepository.findById(id);
    }

    public Mono<Car> save(Car car) {
        return carRepository.save(car);
    }
}
