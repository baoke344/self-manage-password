package com.baoanh.selfpasswordmanagement.services;

import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

  String extractEmail(String token);

  boolean isCorrectUserToken(String token, UserDetails userDetails);

  String generateToken(Map<String, Object> claims, UserDetails userDetails);
}
