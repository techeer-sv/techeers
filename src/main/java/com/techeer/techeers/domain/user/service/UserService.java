package com.techeer.techeers.domain.user.service;

import com.techeer.techeers.domain.user.entity.UserEntity;
import com.techeer.techeers.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findById(Long id) { //Optional
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id=" + id));

    }

    public void deleteAllData() {
        userRepository.deleteAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
//    void deleteAllData();

    public UserEntity update(Long id, UserEntity updatedEntity) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id=" + id));
        entity.update(
                updatedEntity.getEmail(),
                updatedEntity.getPassword(),
                updatedEntity.getFirstName(),
                updatedEntity.getLastName(),
                updatedEntity.getPhoneNumber()
        );

        return userRepository.save(entity);
    }
}
