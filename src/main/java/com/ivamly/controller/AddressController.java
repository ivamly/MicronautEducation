package com.ivamly.controller;

import com.ivamly.dto.response.AddressResponse;
import com.ivamly.service.AddressService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotEmpty;
import reactor.core.publisher.Mono;

@Controller("/addresses")
public class AddressController {

    private final AddressService addressService;

    @Inject
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @Get("/{id}")
    public Mono<AddressResponse> get(
            @NotEmpty @PathVariable String id
    ) {

    }

    @Put("/{id}")
    public Mono<AddressResponse> update(
            @NotEmpty @PathVariable String id
    ) {

    }
}
