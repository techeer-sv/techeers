package com.techeer.techeers.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false , length = 50)
    private String firstName;  // camelCase

    @Column(nullable = false , length = 50)
    private String email;

    @Column(nullable = false , length = 50)
    private String password;

    @Column(nullable = false , length = 50)
    private String phoneNumber;

    //    @ColumnDefault("user")
//    private String role;
    @Builder
    public UserEntity(String firstName, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}