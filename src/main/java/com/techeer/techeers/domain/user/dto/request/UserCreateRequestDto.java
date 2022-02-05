package com.techeer.techeers.domain.user.dto.request;

import com.techeer.techeers.domain.user.entity.UserEntity;
import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDto {

    private String firstName;

    private String email;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .email(email)
                .firstName(firstName)
                .build();
    }

}
