package com.baoanh.selfpasswordmanagement.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String extractEmail(String token);
    boolean isCorrectUserToken(String token, UserDetails userDetails);
}
