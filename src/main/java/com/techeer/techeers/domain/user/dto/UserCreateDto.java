package com.techeer.techeers.domain.user.dto;

import com.techeer.techeers.domain.user.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {

    private String firstName;
    private String email;
    private String phoneNumber;
    private String password;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .email(email)
                .firstName(firstName)
                .phoneNumber(phoneNumber)
                .password(password)
                .build();
    }
}
