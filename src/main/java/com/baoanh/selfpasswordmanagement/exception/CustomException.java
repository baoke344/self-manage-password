package com.baoanh.selfpasswordmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private int code;
    private String message;
}
