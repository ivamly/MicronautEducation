package com.ivamly.repository;

import com.ivamly.model.Citizen;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;

import java.util.UUID;

@Singleton
public class CitizenRepository {

    @Inject
    private EntityManager entityManager;

    @ReadOnly
    public Citizen findById(UUID id) {
        return entityManager.find(Citizen.class, id);
    }

    @Transactional
    public Citizen save(Citizen citizen) {
        entityManager.persist(citizen);
        return citizen;
    }
}
