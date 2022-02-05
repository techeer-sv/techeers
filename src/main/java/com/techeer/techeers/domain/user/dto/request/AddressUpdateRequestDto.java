package com.techeer.techeers.domain.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressUpdateRequestDto {

    @NotNull
    @Size(max = 50)
    private String state;

    @NotNull
    @Size(max = 50)
    private String city;

    @NotNull
    @Size(max = 50)
    private String zipcode;

    @NotNull
    @Size(max = 50)
    private String street;
}
