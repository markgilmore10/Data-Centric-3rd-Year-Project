package com.sales.exceptions;

import com.sales.models.Book;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BookInputValidator implements Validator {

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "title", "required.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "author", "required.empty");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.isAssignableFrom(aClass);
    }

}