package com.example.filmRecommendService.controller;

import com.example.filmRecommendService.model.entity.User;
import com.example.filmRecommendService.repository.UserRepository;
import com.example.filmRecommendService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public Page<User> getAll(@ParameterObject Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping("/search")
    public Page<User> search(@RequestParam(required = false) String firstName,
                             @RequestParam(required = false) String lastName,
                             @ParameterObject Pageable pageable) {
        return userService.search(firstName, lastName, pageable);
    }

//    @PostMapping("/createUser")
//    public Page<User> sendUser(@RequestParam(required = false) String firstName,
//                               @RequestParam(required = false) String lastName,
//                               @ParameterObject Pageable pageable){
//        return userService.
//    }

}