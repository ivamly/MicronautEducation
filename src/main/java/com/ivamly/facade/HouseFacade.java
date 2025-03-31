package com.ivamly.facade;

import com.ivamly.dto.AddressDto;
import com.ivamly.dto.CreateHouseRequest;
import com.ivamly.dto.GetHouseResponse;
import com.ivamly.model.Address;
import com.ivamly.model.House;
import com.ivamly.service.HouseService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Singleton
public class HouseFacade {

    @Inject
    private HouseService houseService;

    public Mono<GetHouseResponse> get(String id) {
        return houseService.get(UUID.fromString(id))
                .map(this::convert);
    }

    public Mono<GetHouseResponse> create(CreateHouseRequest house) {
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

        return Mono.just(convert(houseEntity));
    }

    private GetHouseResponse convert(House house) {
        if (house == null) {
            throw new RuntimeException("House not found");
        }

        GetHouseResponse getHouseResponse = new GetHouseResponse();

        getHouseResponse.setId(String.valueOf(house.getId()));
        getHouseResponse.setFloor(house.getFloor());

        AddressDto addressDto = new AddressDto();

        addressDto.setId(String.valueOf(house.getAddress().getId()));
        addressDto.setCountry(house.getAddress().getCountry());
        addressDto.setCity(house.getAddress().getCity());
        addressDto.setStreet(house.getAddress().getStreet());

        getHouseResponse.setAddress(addressDto);

        return getHouseResponse;
    }
}
