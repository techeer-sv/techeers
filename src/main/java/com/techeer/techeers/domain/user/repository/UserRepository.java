package com.techeer.techeers.domain.user.repository;

import com.techeer.techeers.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Create
    UserEntity save(UserEntity userEntity);

    //Read
    List<UserEntity> findAll();
    //.get
    // optional
    Optional<UserEntity> findById(Long id);

    @Query("select u from UserEntity u where u.email = ?1")
    Optional<UserEntity> finByEmail(String email);
    //Delete
    void deleteAll();
    //void deleteById();
    //수정

}
