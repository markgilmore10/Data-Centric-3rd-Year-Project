package com.sales.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Employee Not Found") //404
public class NotFoundException extends Exception {

    private static final long serialVersionUID = -3332292346834265371L;

    public NotFoundException(List<String> errors){
        super(errors.toString().substring(1,errors.toString().length()-1));
    }
}