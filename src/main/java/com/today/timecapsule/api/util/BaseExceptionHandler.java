package com.today.timecapsule.api.util;


import com.today.timecapsule.api.util.helper.ResponseHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.EOFException;
import java.sql.SQLException;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
        if (ex instanceof NullPointerException) {
            return ResponseHelper.response(
                    "ex.getCause()",
                    ex.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
        return ResponseHelper.response(
                ex.getClass(),
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }




}
