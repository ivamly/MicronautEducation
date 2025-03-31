package com.ivamly.service;

import com.ivamly.model.House;
import com.ivamly.repository.HouseRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class HouseService {

    @Inject
    private HouseRepository houseRepository;

    public House get(UUID id) {
        return houseRepository.findById(id);
    }

    public House save(House house) {
        return houseRepository.save(house);
    }
}
