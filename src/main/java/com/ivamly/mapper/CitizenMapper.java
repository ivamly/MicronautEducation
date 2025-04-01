package com.ivamly.mapper;

import com.ivamly.dto.response.AddressResponse;
import com.ivamly.dto.response.CitizenResponse;
import com.ivamly.dto.request.CreateCitizenRequest;
import com.ivamly.dto.response.PassportResponse;
import com.ivamly.dto.request.UpdateCitizenRequest;
import com.ivamly.model.Address;
import com.ivamly.model.Citizen;
import com.ivamly.model.Passport;
import jakarta.inject.Singleton;

@Singleton
public class CitizenMapper {

    public Citizen map(CreateCitizenRequest source) {
        Citizen citizen = new Citizen();

        citizen.setName(source.getName());
        citizen.setAge(source.getAge());

        Passport passport = new Passport();

        passport.setSeries(source.getSeries());
        passport.setNumber(source.getNumber());

        Address address = new Address();

        address.setCountry(source.getCountry());
        address.setCity(source.getCity());
        address.setStreet(source.getStreet());

        passport.setAddress(address);

        citizen.setPassport(passport);

        return citizen;
    }

    public Citizen map(UpdateCitizenRequest source) {
        Citizen citizen = new Citizen();

        citizen.setName(source.getName());
        citizen.setAge(source.getAge());

        return citizen;
    }

    public CitizenResponse map(Citizen source) {
        CitizenResponse citizenResponse = new CitizenResponse();

        citizenResponse.setId(String.valueOf(source.getId()));
        citizenResponse.setName(source.getName());
        citizenResponse.setAge(source.getAge());

        PassportResponse passportDto = new PassportResponse();

        passportDto.setId(String.valueOf(source.getPassport().getId()));
        passportDto.setSeries(source.getPassport().getSeries());
        passportDto.setNumber(source.getPassport().getNumber());

        AddressResponse addressDto = new AddressResponse();

        addressDto.setId(String.valueOf(source.getPassport().getAddress().getId()));
        addressDto.setCountry(source.getPassport().getAddress().getCountry());
        addressDto.setCity(source.getPassport().getAddress().getCity());
        addressDto.setStreet(source.getPassport().getAddress().getStreet());

        passportDto.setAddress(addressDto);

        citizenResponse.setPassport(passportDto);

        return citizenResponse;
    }
}
