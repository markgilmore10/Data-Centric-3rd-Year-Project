package com.sales.exceptions;

import com.sales.models.Book;
import com.sales.models.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomerInputValidation implements Validator {

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "cName", "required.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "loanPeriod", "required.tooSmall");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.isAssignableFrom(aClass);
    }

}
