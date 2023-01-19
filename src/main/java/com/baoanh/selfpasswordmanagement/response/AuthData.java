package com.baoanh.selfpasswordmanagement.response;

import lombok.Data;

@Data
public class AuthData {

    private Integer id;
    private String accessToken;
    private String refreshToken;
}
