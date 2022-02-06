package com.techeer.techeers.domain.user.dto.request;

import lombok.*;

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

    private AddressCreateRequestDto address;

}
