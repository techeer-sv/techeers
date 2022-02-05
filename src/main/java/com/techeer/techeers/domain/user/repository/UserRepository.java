package com.techeer.techeers.domain.user.repository;

import com.techeer.techeers.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // Create
    UserEntity save(UserEntity userEntity);
    //Read
    List<UserEntity> findAll();

    //null check
    //.get
    Optional<UserEntity> findById(Long id);
    //삭제
    void deleteAll();
//    void deleteById();
    //수정

}
