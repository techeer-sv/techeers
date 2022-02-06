package com.techeer.techeers.domain.user.dto.mapper;

import com.techeer.techeers.domain.user.dto.request.AddressCreateRequestDto;
import com.techeer.techeers.domain.user.dto.request.AddressUpdateRequestDto;
import com.techeer.techeers.domain.user.dto.response.AddressResponseDto;
import com.techeer.techeers.domain.user.dto.response.UserResponseDto;
import com.techeer.techeers.domain.user.entity.Address;
import com.techeer.techeers.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address toEntity(AddressCreateRequestDto dto) {
        return Address.builder()
                .state(dto.getState())
                .city(dto.getCity())
                .zipcode(dto.getZipcode())
                .street(dto.getStreet())
                .build();
    }

    public Address toEntity(AddressUpdateRequestDto dto) {
        return Address.builder()
                .state(dto.getState())
                .city(dto.getCity())
                .zipcode(dto.getZipcode())
                .street(dto.getStreet())
                .build();
    }


    public AddressResponseDto toResponseDto(Address dto) {
        return AddressResponseDto.builder()
                .id(dto.getId())
                .state(dto.getState())
                .city(dto.getCity())
                .zipcode(dto.getZipcode())
                .street(dto.getStreet())
                .build();
    }
}
