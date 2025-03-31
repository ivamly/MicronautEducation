package com.ivamly.service;

import com.ivamly.model.Citizen;
import io.micronaut.context.annotation.Property;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest(startApplication = false)
@Property(name = "datasources.default.driver-class-name", value = "org.testcontainers.jdbc.ContainerDatabaseDriver")
@Property(name = "datasources.default.url", value = "jdbc:tc:postgresql:15.2-alpine:///db?TC_INITSCRIPT=sql/init-db.sql")
@Property(name = "datasources.default.username", value = "your_username")
@Property(name = "datasources.default.password", value = "your_password")
class CitizenServiceTest {

    @Inject
    private CitizenService citizenService;

    @Test
    void testSaveAndGetCitizen() {

        Citizen citizen = new Citizen();
        citizen.setId(UUID.randomUUID());
        citizen.setName("John Doe");
        citizen.setAge(30);

        Mono<Citizen> savedCitizenMono = citizenService.save(citizen);
        Citizen savedCitizen = savedCitizenMono.block();
        System.out.println(savedCitizen);

        assertNotNull(savedCitizen);
        assertEquals(savedCitizen.getId(), citizen.getId());
        assertEquals(savedCitizen.getName(), citizen.getName());
        assertEquals(savedCitizen.getAge(), citizen.getAge());

        Mono<Citizen> retrievedCitizenMono = citizenService.get(savedCitizen.getId());
        Citizen retrievedCitizen = retrievedCitizenMono.block();
        System.out.println(retrievedCitizen);

        assertNotNull(retrievedCitizen);
        assertEquals(retrievedCitizen.getId(), citizen.getId());
        assertEquals(retrievedCitizen.getName(), citizen.getName());
        assertEquals(retrievedCitizen.getAge(), citizen.getAge());
    }
}