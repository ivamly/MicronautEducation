package com.ivamly.mapper;

import com.ivamly.dto.response.AddressResponse;
import com.ivamly.dto.request.CreateHouseRequest;
import com.ivamly.dto.response.HouseResponse;
import com.ivamly.dto.request.UpdateHouseRequest;
import com.ivamly.model.Address;
import com.ivamly.model.House;
import jakarta.inject.Singleton;

@Singleton
public class HouseMapper {

    public House map(CreateHouseRequest source) {
        House house = new House();

        house.setFloor(source.getFloor());

        Address address = new Address();

        address.setCountry(source.getCountry());
        address.setCity(source.getCity());
        address.setStreet(source.getStreet());

        house.setAddress(address);

        return house;
    }

    public House map(UpdateHouseRequest source) {
        House house = new House();

        house.setFloor(source.getFloor());

        return house;
    }

    public HouseResponse map(House source) {
        HouseResponse getHouseResponse = new HouseResponse();

        getHouseResponse.setId(String.valueOf(source.getId()));
        getHouseResponse.setFloor(source.getFloor());

        AddressResponse addressDto = new AddressResponse();

        addressDto.setId(String.valueOf(source.getAddress().getId()));
        addressDto.setCountry(source.getAddress().getCountry());
        addressDto.setCity(source.getAddress().getCity());
        addressDto.setStreet(source.getAddress().getStreet());

        getHouseResponse.setAddress(addressDto);

        return getHouseResponse;
    }
}
