package com.ivamly.controller;

import com.ivamly.dto.response.CarResponse;
import com.ivamly.dto.request.CreateCarRequest;
import com.ivamly.mapper.CarMapper;
import com.ivamly.service.CarService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Controller("/cars")
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    @Inject
    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @Get("/{id}")
    public Mono<CarResponse> get(
            @NotEmpty @PathVariable String id
    ) {
        return carService.get(
                        UUID.fromString(id))
                .map(carMapper::map);
    }

    @Post
    public Mono<CarResponse> create(
            @Valid @Body CreateCarRequest request
    ) {
        return carService.save(
                        carMapper.map(request))
                .map(carMapper::map);
    }
//
//    @Put("/{id}")
//    public Mono<HouseResponse> update(
//            @NotEmpty @PathVariable String id,
//            @Valid @Body UpdateCarRequest request
//    ) {
//
//    }
//
//    @Delete("/{id}")
//    public void delete(
//            @NotEmpty @PathVariable String id
//    ) {
//
//    }
}
