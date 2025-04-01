package com.ivamly.controller;

import com.ivamly.dto.response.PassportResponse;
import com.ivamly.service.PassportService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotEmpty;
import reactor.core.publisher.Mono;

@Controller("/passports")
public class PassportController {

    private final PassportService passportService;

    @Inject
    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @Get("/{id}")
    public Mono<PassportResponse> get(
            @NotEmpty @PathVariable String id) {

    }

    @Put("/{id}")
    public Mono<PassportResponse> update(
            @NotEmpty @PathVariable String id
    ) {

    }
}
