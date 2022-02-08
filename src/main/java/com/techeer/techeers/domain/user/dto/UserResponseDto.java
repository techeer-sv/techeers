package com.techeer.techeers.domain.user.dto;

import com.techeer.techeers.domain.user.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private String firstName;
    private String email;
    private String phoneNumber;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .email(email)
                .firstName(firstName)
                .phoneNumber(phoneNumber)
                .build();
    }
}