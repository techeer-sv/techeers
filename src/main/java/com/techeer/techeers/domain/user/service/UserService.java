package com.techeer.techeers.domain.user.service;

import com.techeer.techeers.domain.user.dto.mapper.UserMapper;
import com.techeer.techeers.domain.user.dto.request.UserCreateRequestDto;
import com.techeer.techeers.domain.user.entity.User;
import com.techeer.techeers.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Transactional
    public User save(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userRepository.save(entity);
    }

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User findById(Long id) { //Optional
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id=" + id));
    }

    @Transactional
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email=" + email));
    }

    @Transactional
    public User update(Long id, User updatedEntity) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id=" + id));
        entity.update(
                updatedEntity.getEmail(),
                updatedEntity.getPassword(),
                updatedEntity.getFirstName(),
                updatedEntity.getLastName(),
                updatedEntity.getPhoneNumber(),
                updatedEntity.getAddress()
        );

        return userRepository.save(entity);
    }

    @Transactional
    public void deleteAllData() {
        userRepository.deleteAll();
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void checkEmailDuplication(UserCreateRequestDto dto) {
        boolean usernameDuplicate = userRepository.existsByEmail(userMapper.toEntity(dto).getEmail());
        if (usernameDuplicate) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
    }


}
