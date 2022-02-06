package com.techeer.techeers.domain.user.repository;

import com.techeer.techeers.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//
//    User save(User user);
//    List<User> findAll();
//    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
//    void deleteAll();
//    void deleteById(Long id);
}
