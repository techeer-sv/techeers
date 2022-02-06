package com.techeer.techeers.domain.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressCreateRequestDto {
    private String state;
    private String city;
    private String zipcode;
    private String street;
}
