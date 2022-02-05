package com.techeer.techeers.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Builder
    public Address(User user, String state, String city, String zipcode, String street) {
        this.user = user;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
    }

    public void update(User user, String state, String city, String zipcode, String street) {
        this.user = user;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
    }
}
