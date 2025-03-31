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
import reactor.core.publisher.Mono;

import java.util.UUID;

@Singleton
public class CitizenFacade {

    @Inject
    private CitizenService citizenService;

    public Mono<GetCitizenResponse> get(String id) {
        return citizenService.get(UUID.fromString(id))
                .map(this::convert);
    }

    public Mono<GetCitizenResponse> create(CreateCitizenRequest citizen) {
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

        return Mono.just(convert(citizenEntity));
    }

    private GetCitizenResponse convert(Citizen citizen) {
        if (citizen == null) {
            throw new RuntimeException("Citizen not found");
        }

        GetCitizenResponse getCitizenResponse = new GetCitizenResponse();

        getCitizenResponse.setId(String.valueOf(citizen.getId()));
        getCitizenResponse.setName(citizen.getName());
        getCitizenResponse.setAge(citizen.getAge());

        PassportDto passportDto = new PassportDto();

        passportDto.setId(String.valueOf(citizen.getPassport().getId()));
        passportDto.setSeries(citizen.getPassport().getSeries());
        passportDto.setNumber(citizen.getPassport().getNumber());

        AddressDto addressDto = new AddressDto();

        addressDto.setId(String.valueOf(citizen.getPassport().getAddress().getId()));
        addressDto.setCountry(citizen.getPassport().getAddress().getCountry());
        addressDto.setCity(citizen.getPassport().getAddress().getCity());
        addressDto.setStreet(citizen.getPassport().getAddress().getStreet());

        passportDto.setAddress(addressDto);

        getCitizenResponse.setPassport(passportDto);

        return getCitizenResponse;
    }
}
