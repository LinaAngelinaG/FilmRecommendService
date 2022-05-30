package com.example.filmRecommendService.validationErrors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class UserValidatorError {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Getter
    private List<String> errors = new ArrayList<>();
    @Getter
    private final String errorMessage;
    public UserValidatorError(String errorMessage){
        this.errorMessage = errorMessage;
    }
    public void addValidationError(String error) {
        errors.add(error);
    }
}
