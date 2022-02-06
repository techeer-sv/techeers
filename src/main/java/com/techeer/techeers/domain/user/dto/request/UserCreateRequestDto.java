package com.techeer.techeers.domain.user.dto.request;

import com.techeer.techeers.domain.user.entity.UserEntity;
import lombok.*;

import javax.persistence.Id;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDto {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;


//    public UserEntity toEntity() {
//        return UserEntity.builder()
//                .email(email)
//                .firstName(firstName)
//                .lastName(lastName)
//                .password(password)
//                .phoneNumber(phoneNumber)
//                .build();
//    }

}
