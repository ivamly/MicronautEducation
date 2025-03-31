package com.ivamly.repository;

import com.ivamly.model.Car;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;

import java.util.UUID;

@Repository
public interface CarRepository extends ReactorCrudRepository<Car, UUID> {
}
