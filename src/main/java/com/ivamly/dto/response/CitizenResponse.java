package com.ivamly.dto.response;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class CitizenResponse {

    /**
     * Identifier.
     */
    private String id;

    /**
     * Name of the citizen.
     */
    private String name;

    /**
     * Age of the citizen.
     */
    private Integer age;

    /**
     * Passport information {@link PassportResponse}.
     */
    private PassportResponse passport;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PassportResponse getPassport() {
        return passport;
    }

    public void setPassport(PassportResponse passport) {
        this.passport = passport;
    }
}
