package com.ivamly.controller;

import com.ivamly.dto.request.CreateCitizenRequest;
import com.ivamly.dto.response.CitizenResponse;
import com.ivamly.mapper.CitizenMapper;
import com.ivamly.service.CitizenService;
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

@Controller("/citizens")
public class CitizenController {

    private final CitizenService citizenService;
    private final CitizenMapper citizenMapper;

    @Inject
    public CitizenController(CitizenService citizenService, CitizenMapper citizenMapper) {
        this.citizenService = citizenService;
        this.citizenMapper = citizenMapper;
    }

    @Get("/{id}")
    public Mono<CitizenResponse> get(
            @NotEmpty @PathVariable String id
    ) {
        return citizenService.get(
                        UUID.fromString(id))
                .map(citizenMapper::map);
    }

    @Post
    public Mono<CitizenResponse> create(
            @Valid @Body CreateCitizenRequest request
    ) {
        return citizenService.save(
                        citizenMapper.map(request))
                .map(citizenMapper::map);
    }
}
