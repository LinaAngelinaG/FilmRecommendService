package com.example.filmRecommendService.service;

import com.example.filmRecommendService.model.dto.UserDto;
import com.example.filmRecommendService.model.entity.User;
import com.example.filmRecommendService.repository.UserRepository;
import com.example.filmRecommendService.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto getUser(String login) {
        return userRepository.findByLogin(login)
                .map(userMapper::toDto)
                .orElseThrow();
    }
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Page<User> search(String firstName, String lastName, Pageable pageable) {
        return userRepository.findAll(Specification.where(hasFirstName(firstName))
                .and(hasLastName(lastName)), pageable);
    }

    private Specification<User> hasLastName(String lastName) {
        if (lastName != null && lastName.length() > 0) {
            return (root, query, cb) -> cb.like(cb.upper(root.get("lastName")), lastName.toUpperCase()+"%");
        }
        return null;
    }

    private Specification<User> hasFirstName(String firstName) {
        if (firstName != null && firstName.length() > 0) {
            return (root, query, cb) -> cb.like(cb.upper(root.get("firstName")), firstName.toUpperCase()+"%");
        }
        return null;
    }
}
