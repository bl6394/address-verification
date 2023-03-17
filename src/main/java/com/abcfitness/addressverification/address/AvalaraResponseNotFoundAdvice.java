package com.abcfitness.addressverification.address;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AvalaraResponseNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AvalaraResponseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String avalaraResponseNotFoundHandler(AvalaraResponseNotFoundException ex) {
        return ex.getMessage();
    }
}
