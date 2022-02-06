package com.techeer.techeers.domain.user.service;

import com.techeer.techeers.domain.user.entity.UserEntity;
import com.techeer.techeers.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//import javax.transaction.Transactional;


//@RequiredArgsConstructor -> lombock
@Service // 서비스에 필수
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    } // 의존성

    @Transactional
    public UserEntity create(UserEntity user) {
        return userRepository.save(user);
    }

    @Transactional
//    public Optional < Employee > findById(Long id) {
    public UserEntity findById(Long id) {
        return userRepository.getById(id);
    }
}
