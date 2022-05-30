package com.example.filmRecommendService.model.builder;

import com.example.filmRecommendService.model.entity.User;

import javax.validation.constraints.NotNull;

public class UserBuilder {
    private static UserBuilder instance = new UserBuilder();
    private Long id = null;
    private String login = "";
    private String password = "";
    private String email = "";

    private UserBuilder(){}

    public static UserBuilder create(){
        return instance;
    }

    public UserBuilder withLogin(String login){
        this.login = login;
        return instance;
    }

    public UserBuilder withEmail(String email){
        this.email = email;
        return instance;
    }

    public UserBuilder withId(@NotNull Long id){
        this.id = id;
        return instance;
    }

    public UserBuilder withPassword(String password){
        this.password = password;
        return instance;
    }

    public User build(){
        User result = new User();
        result.setId(id);
        result.setEmail(email);
        result.setLogin(login);
        result.setPassword(password);
        return result;
    }
}
