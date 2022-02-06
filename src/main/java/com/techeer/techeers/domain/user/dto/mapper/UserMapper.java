package com.techeer.techeers.domain.user.dto.mapper;

import com.techeer.techeers.domain.user.dto.request.UserCreateRequestDto;
import com.techeer.techeers.domain.user.dto.request.UserUpdateRequestDto;
import com.techeer.techeers.domain.user.dto.response.UserResponseDto;
import com.techeer.techeers.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final AddressMapper addressMapper;

    public User toEntity(UserCreateRequestDto dto) {
        return User.builder()
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .password(dto.getPassword())
                .phoneNumber(dto.getPhoneNumber())
                .address(addressMapper.toEntity(dto.getAddress()))
                .build();
    }

    public UserResponseDto toResponseDto(User entity) {
        return UserResponseDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .phoneNumber(entity.getPhoneNumber())
                .address(addressMapper.toResponseDto(entity.getAddress()))
                .build();
    }

    public User toEntity(UserUpdateRequestDto dto) {
        return User.builder()
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .phoneNumber(dto.getPhoneNumber())
                .address(addressMapper.toEntity(dto.getAddress()))
                .build();
    }
}
