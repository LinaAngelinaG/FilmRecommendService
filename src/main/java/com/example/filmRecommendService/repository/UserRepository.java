package com.example.filmRecommendService.repository;

import com.example.filmRecommendService.model.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long>, JpaSpecificationExecutor<User> {
    Optional<User> findByLogin(String login);
    @GetMapping("/user/{id}")
    Optional<User> findById(@PathVariable Long id);
    @GetMapping("/user")
    Iterable<User> findAll();

}
