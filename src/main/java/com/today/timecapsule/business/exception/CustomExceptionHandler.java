package com.today.timecapsule.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(StackOverflowError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomException handleStackOverflowError(StackOverflowError ex) {
        CustomException customException = new CustomException();
        customException.setMsg("stack_overflow_error");
        customException.setData(ex.getMessage());
        return customException;
    }


}

