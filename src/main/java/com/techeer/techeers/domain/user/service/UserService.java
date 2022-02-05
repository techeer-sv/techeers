package com.techeer.techeers.domain.user.service;

import com.techeer.techeers.domain.user.entity.UserEntity;
import com.techeer.techeers.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
//        return userEntity;
    }

    public List<UserEntity> findUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteAllData() {
        userRepository.deleteAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
//    void deleteAllData();

    // 삭제
    // 수정

}
