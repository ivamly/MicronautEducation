package com.ivamly.service;

import com.ivamly.model.Citizen;
import com.ivamly.repository.CitizenRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Singleton
public class CitizenService {

    @Inject
    private CitizenRepository citizenRepository;

    public Mono<Citizen> get(UUID id) {
        return citizenRepository.findById(id);
    }

    public Mono<Citizen> save(Citizen citizen) {
        return citizenRepository.save(citizen);
    }
}