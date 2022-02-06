package com.techeer.techeers.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private User user;

    @NotNull
    private String state;

    @NotNull
    private String city;

    @NotNull
    private String zipcode;

    @NotNull
    private String street;

    @Builder
    public Address(User user, String state, String city, String zipcode, String street) {
        this.user = user;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
    }
    public void update(User user, String state, String city, String zipcode, String street) {
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;

    }
}
