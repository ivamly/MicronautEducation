package com.ivamly.repository;

import com.ivamly.model.Citizen;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;

import java.util.UUID;

@Repository
public interface CitizenRepository extends ReactorCrudRepository<Citizen, UUID> {
}
