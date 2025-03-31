package com.ivamly.dto;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class GetCitizenResponse {

    private String id;

    private String name;

    private Integer age;

    private PassportDto passport;

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

    public PassportDto getPassport() {
        return passport;
    }

    public void setPassport(PassportDto passport) {
        this.passport = passport;
    }
}
