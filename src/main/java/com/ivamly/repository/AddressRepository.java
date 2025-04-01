package com.ivamly.repository;

import com.ivamly.model.Address;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;

import java.util.UUID;

@Repository
public interface AddressRepository extends ReactorCrudRepository<Address, UUID> {
}
