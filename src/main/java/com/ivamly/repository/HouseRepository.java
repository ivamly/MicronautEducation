package com.ivamly.repository;

import com.ivamly.model.House;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;

import java.util.UUID;

@Singleton
public class HouseRepository {

    @Inject
    private EntityManager entityManager;

    @ReadOnly
    public House findById(UUID id) {
        return entityManager.find(House.class, id);
    }

    @Transactional
    public House save(House house) {
        entityManager.persist(house);
        return house;
    }
}
