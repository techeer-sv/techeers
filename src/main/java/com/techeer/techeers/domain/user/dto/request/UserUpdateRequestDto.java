package com.techeer.techeers.domain.user.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String email;

    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String phoneNumber;

}
