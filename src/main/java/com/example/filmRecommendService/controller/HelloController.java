package com.example.filmRecommendService.controller;

import com.example.filmRecommendService.model.dto.UserDto;
import com.example.filmRecommendService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class HelloController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getProfile(Principal principal) {
        if (principal.getName().equals("admin")) {
            return ResponseEntity.ok(userService.getUser(principal.getName()));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
