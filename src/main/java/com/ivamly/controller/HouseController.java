package com.ivamly.controller;

import com.ivamly.dto.CreateHouseRequest;
import com.ivamly.dto.GetHouseResponse;
import com.ivamly.facade.HouseFacade;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@Controller("/house")
public class HouseController {

    @Inject
    private HouseFacade houseFacade;

    @Get
    public Mono<GetHouseResponse> get(String id) {
        return houseFacade.get(id);
    }

    @Post
    public Mono<GetHouseResponse> create(@Body @Valid CreateHouseRequest request) {
        return houseFacade.create(request);
    }
}
