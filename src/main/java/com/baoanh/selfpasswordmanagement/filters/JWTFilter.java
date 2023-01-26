package com.baoanh.selfpasswordmanagement.filters;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import com.baoanh.selfpasswordmanagement.exception.CustomException;
import com.baoanh.selfpasswordmanagement.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;

  private boolean validAuthHeader(String authHeader) {
    return authHeader != null && authHeader.startsWith("Bearer ");
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain) throws ServletException, IOException {
    final String authHeader = request.getHeader(AUTHORIZATION);
    if (!validAuthHeader(authHeader)) {
      throw new CustomException(HttpStatus.BAD_REQUEST.value(), "Invalid authorization header");
    }
    String token = authHeader.substring(7);
    String userEmail = jwtService.extractEmail(token);
    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() != null) {
      UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
      if (jwtService.isCorrectUserToken(token, userDetails)) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            userDetails, null, userDetails.getAuthorities());
        authToken.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);
      }
    }
    filterChain.doFilter(request, response);
  }
}
