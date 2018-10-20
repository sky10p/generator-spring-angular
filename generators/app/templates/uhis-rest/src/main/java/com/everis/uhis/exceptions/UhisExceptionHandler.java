package com.everis.uhis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class UhisExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler({ Throwable.class })
    public final ResponseEntity<ErrorDetails> handleException(Throwable ex, WebRequest request)
    {
        ErrorDetails errorDetails;

        errorDetails = new ErrorDetails(ex, HttpStatus.INTERNAL_SERVER_ERROR.value(), request);

        return errorDetails.asResponseEntity();
    }

}
