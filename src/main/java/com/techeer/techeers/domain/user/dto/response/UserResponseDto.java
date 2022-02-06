package com.techeer.techeers.domain.user.dto.response;

import com.techeer.techeers.domain.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

//    public UserResponseDto toResponseDto() {
//        return UserResponseDto.builder()
//                .id(id)
//                .email(email)
//                .firstName(firstName)
//                .lastName(lastName)
//                .phoneNumber(phoneNumber)
//                .build();
//    }
}
