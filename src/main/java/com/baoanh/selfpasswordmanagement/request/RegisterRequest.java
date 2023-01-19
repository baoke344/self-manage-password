package com.baoanh.selfpasswordmanagement.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterRequest {

    private String email;
    private String firstName;
    private String lastName;
    private String passWord;
}
