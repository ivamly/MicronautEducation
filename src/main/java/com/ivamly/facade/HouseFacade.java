package com.ivamly.facade;

import com.ivamly.dto.AddressDto;
import com.ivamly.dto.CreateHouseRequest;
import com.ivamly.dto.GetHouseResponse;
import com.ivamly.model.Address;
import com.ivamly.model.House;
import com.ivamly.service.HouseService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class HouseFacade {

    @Inject
    private HouseService houseService;

    public GetHouseResponse get(String id) {
        House houseEntity = houseService.get(UUID.fromString(id));

        if (houseEntity == null) {
            throw new RuntimeException("House not found");
        }

        GetHouseResponse getHouseResponse = new GetHouseResponse();

        getHouseResponse.setId(String.valueOf(houseEntity.getId()));
        getHouseResponse.setFloor(houseEntity.getFloor());

        AddressDto addressDto = new AddressDto();

        addressDto.setId(String.valueOf(houseEntity.getAddress().getId()));
        addressDto.setCountry(houseEntity.getAddress().getCountry());
        addressDto.setCity(houseEntity.getAddress().getCity());
        addressDto.setStreet(houseEntity.getAddress().getStreet());

        getHouseResponse.setAddress(addressDto);

        return getHouseResponse;
    }

    public GetHouseResponse create(CreateHouseRequest house) {
        House houseEntity = new House();

        houseEntity.setId(UUID.randomUUID());
        houseEntity.setFloor(house.getFloor());

        Address address = new Address();

        address.setId(UUID.randomUUID());
        address.setCountry(house.getCountry());
        address.setCity(house.getCity());
        address.setStreet(house.getStreet());

        houseEntity.setAddress(address);

        houseService.save(houseEntity);

        GetHouseResponse getHouseResponse = new GetHouseResponse();

        getHouseResponse.setId(String.valueOf(houseEntity.getId()));
        getHouseResponse.setFloor(houseEntity.getFloor());

        AddressDto addressDto = new AddressDto();

        addressDto.setId(String.valueOf(houseEntity.getAddress().getId()));
        addressDto.setCountry(houseEntity.getAddress().getCountry());
        addressDto.setCity(houseEntity.getAddress().getCity());
        addressDto.setStreet(houseEntity.getAddress().getStreet());

        getHouseResponse.setAddress(addressDto);

        return getHouseResponse;
    }
}
