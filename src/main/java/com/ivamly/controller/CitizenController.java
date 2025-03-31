package com.ivamly.controller;

import com.ivamly.dto.CreateCitizenRequest;
import com.ivamly.dto.GetCitizenResponse;
import com.ivamly.facade.CitizenFacade;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

@Controller("/citizen")
public class CitizenController {

    @Inject
    private CitizenFacade citizenFacade;

    @Get
    public GetCitizenResponse get(String id) {
        return citizenFacade.get(id);
    }

    @Post
    public GetCitizenResponse create(@Body @Valid CreateCitizenRequest request) {
        return citizenFacade.create(request);
    }
}
