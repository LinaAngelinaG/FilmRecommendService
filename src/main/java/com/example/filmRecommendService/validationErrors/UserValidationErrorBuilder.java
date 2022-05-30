package com.example.filmRecommendService.validationErrors;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class UserValidationErrorBuilder {
    public static UserValidatorError fromBindingErrors(Errors errors){
        UserValidatorError error = new UserValidatorError(
          "Validation failed. " + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getAllErrors()){
            error.addValidationError(objectError.getDefaultMessage());
        }
        return error;
    }
}
