package com.ivamly.repository;

import com.ivamly.model.House;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;

import java.util.UUID;

@Repository
public interface HouseRepository extends ReactorCrudRepository<House, UUID> {
}
