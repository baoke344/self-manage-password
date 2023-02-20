package com.baoanh.selfpasswordmanagement.aop;

import com.baoanh.selfpasswordmanagement.exception.CustomException;
import com.baoanh.selfpasswordmanagement.response.Error;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.baoanh.selfpasswordmanagement.controllers")
@RequestMapping
public class CustomExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<Error> handlerException(final CustomException ex) {
    return new ResponseEntity<>(new Error(ex.getCode(), ex.getMessage()), HttpStatusCode.valueOf(
        ex.getCode()));
  }
}
