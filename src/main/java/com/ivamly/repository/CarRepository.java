package com.ivamly.repository;

import com.ivamly.model.Car;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;

import java.util.UUID;

@Singleton
public class CarRepository {

    @Inject
    private EntityManager entityManager;

    @ReadOnly
    public Car findById(UUID id) {
        return entityManager.find(Car.class, id);
    }

    @Transactional
    public Car save(Car car) {
        entityManager.persist(car);
        return car;
    }
}
