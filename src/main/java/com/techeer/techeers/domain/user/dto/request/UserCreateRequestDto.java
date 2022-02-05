package com.techeer.techeers.domain.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDto {

    @Size(max = 255)
    private String email;

    @Size(max = 16)
    private String password;
}
