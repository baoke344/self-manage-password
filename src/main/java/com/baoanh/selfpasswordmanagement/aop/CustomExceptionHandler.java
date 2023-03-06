package com.baoanh.selfpasswordmanagement.aop;

import com.baoanh.selfpasswordmanagement.exception.CustomException;
import com.baoanh.selfpasswordmanagement.response.Error;
import javax.naming.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<Error> handlerException(final CustomException ex) {
    return ResponseEntity.badRequest().body(new Error(ex.getCode(), ex.getMessage()));
  }

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<Error> handlerAuthenticationException(final Exception ex) {

    return ResponseEntity.badRequest().body(new Error(HttpStatus.UNAUTHORIZED.value(), ex.getMessage()));
  }
}
