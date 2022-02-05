package com.techeer.techeers.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDto {

    private String state;
    private String city;
    private String zipcode;
    private String street;
}
