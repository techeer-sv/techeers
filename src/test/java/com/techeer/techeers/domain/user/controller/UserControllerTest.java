package com.techeer.techeers.domain.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techeer.techeers.domain.user.dto.mapper.AddressMapper;
import com.techeer.techeers.domain.user.dto.mapper.UserMapper;
import com.techeer.techeers.domain.user.dto.request.AddressCreateRequestDto;
import com.techeer.techeers.domain.user.dto.request.UserCreateRequestDto;
import com.techeer.techeers.domain.user.dto.response.AddressResponseDto;
import com.techeer.techeers.domain.user.dto.response.UserResponseDto;
import com.techeer.techeers.domain.user.entity.Address;
import com.techeer.techeers.domain.user.entity.User;
import com.techeer.techeers.domain.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ActiveProfiles("test")
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    public static String asJsonString(Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserEntity() {
        return User.builder()
                .email("test@test.com")
                .password("testpass")
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("010-1111-1111")
                .address(Address.builder()
                        .state("California")
                        .city("Sunnyvale")
                        .zipcode("40123")
                        .street("Old Town Rd")
                        .build())
                .build();
    }

    @Test
    @DisplayName("Test create user")
    public void testCreate() throws Exception {

        // given
        String uri = "/api/v1/users";
        UserCreateRequestDto requestDto =
                UserCreateRequestDto.builder()
                        .email("test@test.com")
                        .password("testpass")
                        .firstName("John")
                        .lastName("Doe")
                        .phoneNumber("010-1111-1111")
                        .address(AddressCreateRequestDto.builder()
                                .state("California")
                                .city("Sunnyvale")
                                .zipcode("40123")
                                .street("Old Town Rd")
                                .build())
                        .build();

        User user = getUserEntity();
        given(userService.create(Mockito.any()))
                .willReturn(user);

        // when
        final ResultActions actions =
                mvc.perform(post(uri)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(requestDto))
                                .characterEncoding("UTF-8")
                                .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andDo(print());

        // then
        UserResponseDto userResponseDto =
                UserResponseDto.builder()
                        .email("test@test.com")
                        .firstName("John")
                        .lastName("Doe")
                        .phoneNumber("010-1111-1111")
                        .address(AddressResponseDto.builder()
                                .state("California")
                                .city("Sunnyvale")
                                .zipcode("40123")
                                .street("Old Town Rd")
                                .build())
                        .build();


        // TODO: Fix null in response body and check jsonPath of response
        actions
                .andExpect(status().isCreated())
        ;
    }
}
