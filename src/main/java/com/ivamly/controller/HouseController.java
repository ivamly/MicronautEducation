package com.ivamly.controller;

import com.ivamly.dto.request.CreateHouseRequest;
import com.ivamly.dto.response.HouseResponse;
import com.ivamly.mapper.HouseMapper;
import com.ivamly.service.HouseService;
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

@Controller("/houses")
public class HouseController {

    private final HouseService houseService;
    private final HouseMapper houseMapper;

    @Inject
    public HouseController(HouseService houseService, HouseMapper houseMapper) {
        this.houseService = houseService;
        this.houseMapper = houseMapper;
    }

    @Get("/{id}")
    public Mono<HouseResponse> get(
            @NotEmpty @PathVariable String id
    ) {
        return houseService.get(
                        UUID.fromString(id))
                .map(houseMapper::map);
    }

    @Post
    public Mono<HouseResponse> create(
            @Valid @Body CreateHouseRequest request
    ) {
        return houseService.save(
                        houseMapper.map(request))
                .map(houseMapper::map);
    }
//
//    @Put("/{id}")
//    public Mono<CarResponse> update(
//            @NotEmpty @PathVariable String id,
//            @Valid @Body UpdateHouseRequest request
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
