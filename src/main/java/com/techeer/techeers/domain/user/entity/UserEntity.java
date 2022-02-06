package com.techeer.techeers.domain.user.entity;

import lombok.*;
import org.apache.catalina.User;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
    private String phoneNumber;

    @Column(nullable = false , length = 50)
    private String password;


    //    @ColumnDefault("user")
//    private String role;
    @Builder
    public UserEntity(String firstName, String email, String phoneNumber,String password ) {
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;

    }
}