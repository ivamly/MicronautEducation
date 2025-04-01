package com.ivamly.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.util.Set;
import java.util.UUID;

@Entity
public class Citizen {

    /**
     * Unique identifier for the citizen.
     */
    @Id
    private UUID id;

    /**
     * Name of the citizen.
     */
    private String name;

    /**
     * Age of the citizen.
     */
    private Integer age;

    /**
     * Passport information.
     * Represents a one-to-one relationship with the {@link Passport} entity.
     */
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Passport passport;

    /**
     * Car information.
     * Represents a one-to-one relationship with the {@link Car} entity.
     */
    @OneToOne
    private Car car;

    /**
     * Set of houses associated with the citizen.
     * Represents a many-to-many relationship with the {@link House} entity.
     */
    @ManyToMany
    @JoinTable(
            name = "house_owners",
            joinColumns = @JoinColumn(name = "citizen_id"),
            inverseJoinColumns = @JoinColumn(name = "house_id")
    )
    private Set<House> houses;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Set<House> getHouses() {
        return houses;
    }

    public void setHouses(Set<House> houses) {
        this.houses = houses;
    }
}
