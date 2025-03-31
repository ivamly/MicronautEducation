package com.ivamly.controller;

import com.ivamly.dto.CreateCarRequest;
import com.ivamly.dto.GetCarResponse;
import com.ivamly.facade.CarFacade;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@Controller("/car")
public class CarController {

    @Inject
    private CarFacade carFacade;

    @Get
    public Mono<GetCarResponse> get(String id) {
        return carFacade.get(id);
    }

    @Post
    public Mono<GetCarResponse> create(@Body @Valid CreateCarRequest request) {
        return carFacade.create(request);
    }
}
