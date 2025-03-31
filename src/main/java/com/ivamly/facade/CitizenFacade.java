package com.ivamly.facade;

import com.ivamly.dto.AddressDto;
import com.ivamly.dto.CreateCitizenRequest;
import com.ivamly.dto.GetCitizenResponse;
import com.ivamly.dto.PassportDto;
import com.ivamly.model.Address;
import com.ivamly.model.Citizen;
import com.ivamly.model.Passport;
import com.ivamly.service.CitizenService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class CitizenFacade {

    @Inject
    private CitizenService citizenService;

    public GetCitizenResponse get(String id) {
        Citizen citizenEntity = citizenService.get(UUID.fromString(id));

        if (citizenEntity == null) {
            throw new RuntimeException("Citizen not found");
        }

        GetCitizenResponse getCitizenResponse = new GetCitizenResponse();

        getCitizenResponse.setId(String.valueOf(citizenEntity.getId()));
        getCitizenResponse.setName(citizenEntity.getName());
        getCitizenResponse.setAge(citizenEntity.getAge());

        PassportDto passportDto = new PassportDto();

        passportDto.setId(String.valueOf(citizenEntity.getPassport().getId()));
        passportDto.setSeries(citizenEntity.getPassport().getSeries());
        passportDto.setNumber(citizenEntity.getPassport().getNumber());

        AddressDto addressDto = new AddressDto();

        addressDto.setId(String.valueOf(citizenEntity.getPassport().getAddress().getId()));
        addressDto.setCountry(citizenEntity.getPassport().getAddress().getCountry());
        addressDto.setCity(citizenEntity.getPassport().getAddress().getCity());
        addressDto.setStreet(citizenEntity.getPassport().getAddress().getStreet());

        passportDto.setAddress(addressDto);

        getCitizenResponse.setPassport(passportDto);

        return getCitizenResponse;
    }

    public GetCitizenResponse create(CreateCitizenRequest citizen) {
        Citizen citizenEntity = new Citizen();

        citizenEntity.setId(UUID.randomUUID());
        citizenEntity.setName(citizen.getName());
        citizenEntity.setAge(citizen.getAge());

        Passport passport = new Passport();

        passport.setId(UUID.randomUUID());
        passport.setSeries(citizen.getSeries());
        passport.setNumber(citizen.getNumber());

        Address address = new Address();

        address.setId(UUID.randomUUID());
        address.setCountry(citizen.getCountry());
        address.setCity(citizen.getCity());
        address.setStreet(citizen.getStreet());

        passport.setAddress(address);

        citizenEntity.setPassport(passport);

        citizenService.save(citizenEntity);

        GetCitizenResponse getCitizenResponse = new GetCitizenResponse();

        getCitizenResponse.setId(String.valueOf(citizenEntity.getId()));
        getCitizenResponse.setName(citizenEntity.getName());
        getCitizenResponse.setAge(citizenEntity.getAge());

        PassportDto passportDto = new PassportDto();

        passportDto.setId(String.valueOf(citizenEntity.getPassport().getId()));
        passportDto.setSeries(citizenEntity.getPassport().getSeries());
        passportDto.setNumber(citizenEntity.getPassport().getNumber());

        AddressDto addressDto = new AddressDto();

        addressDto.setId(String.valueOf(citizenEntity.getPassport().getAddress().getId()));
        addressDto.setCountry(citizenEntity.getPassport().getAddress().getCountry());
        addressDto.setCity(citizenEntity.getPassport().getAddress().getCity());
        addressDto.setStreet(citizenEntity.getPassport().getAddress().getStreet());

        passportDto.setAddress(addressDto);

        getCitizenResponse.setPassport(passportDto);

        return getCitizenResponse;
    }
}
