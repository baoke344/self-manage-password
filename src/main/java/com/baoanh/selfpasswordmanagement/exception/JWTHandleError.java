package com.baoanh.selfpasswordmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTHandleError {

  private int code;
  private String message;
}
