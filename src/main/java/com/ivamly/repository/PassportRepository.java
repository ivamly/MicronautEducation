package com.ivamly.repository;

import com.ivamly.model.Passport;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;

import java.util.UUID;

@Repository
public interface PassportRepository extends ReactorCrudRepository<Passport, UUID> {
}
