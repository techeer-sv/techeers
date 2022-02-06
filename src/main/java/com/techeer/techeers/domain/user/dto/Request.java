package com.techeer.techeers.domain.user.dto;

import com.techeer.techeers.domain.user.entity.UserEntity;
import lombok.Getter;

@Getter
public class Request {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String addressId;
    
}
