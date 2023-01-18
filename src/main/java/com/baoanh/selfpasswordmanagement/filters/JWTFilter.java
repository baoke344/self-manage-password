package com.baoanh.selfpasswordmanagement.filters;

import com.baoanh.selfpasswordmanagement.exception.CustomException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class JWTFilter extends OncePerRequestFilter {

    private boolean validAuthHeader(String authHeader) {
        return !authHeader.isEmpty() && authHeader != null && authHeader.startsWith("Bearer ");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(AUTHORIZATION);
        if(!validAuthHeader(authHeader)) {
            throw new CustomException(HttpStatus.BAD_REQUEST.value(), "Invalid authorization header");
        }
        String token = authHeader.substring(7);
    }
}
