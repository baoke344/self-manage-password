package com.baoanh.selfpasswordmanagement.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthData {

    private Integer id;
    private String accessToken;
    private String refreshToken;
}
