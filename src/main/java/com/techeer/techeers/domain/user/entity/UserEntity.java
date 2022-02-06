package com.techeer.techeers.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
//import javax.persistence.*;

@Entity
@Getter
// 해당 클래스를 스프링이 시작될 때, DB에 테이블로 생성해달라고 하기위한 어노테이션이다.
// User 클래스가 스프링이 시작할 때, MySQL에 테이블을 생성한다.

@NoArgsConstructor // 기본 생성자 생성 jpa entity에서 필수
public class UserEntity {
    @Id //Primary key
    //프로젝트에서 연결된db의 넘버링 전략을 따라간다.  -> 오라클이나 mysql에 따라 바뀐다는 뜻이다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // 시퀀스, auto_increment

    @Column(nullable = false, length = 50)
    private String firstName; // 이름

    @Column(nullable = false, length = 50)
    private String lastName; // 성

    @Column(nullable = false, length = 50)
    private String email; // 아이디

    @Column(nullable = false, length = 50) // -> 비밀번호를 암호화 하기위해서 해쉬를 사용해야 한다.
    private String password;

    @Column(nullable = false, length = 50)
    private String phoneNumber; // 휴대폰 번호

    @Column(nullable = false, length = 50)
    private String addressId;  // address_id

    @Builder // 디자인 패턴
    public UserEntity(Long userId, String firstName, String lastName, String email, String password, String phoneNumber, String addressId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
    }
}


