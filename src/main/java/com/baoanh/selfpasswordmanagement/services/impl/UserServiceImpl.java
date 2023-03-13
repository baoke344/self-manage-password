package com.baoanh.selfpasswordmanagement.services.impl;

import com.baoanh.selfpasswordmanagement.repository.dto.Role;
import com.baoanh.selfpasswordmanagement.repository.dto.User;
import com.baoanh.selfpasswordmanagement.exception.CustomException;
import com.baoanh.selfpasswordmanagement.repository.UserPostGreRepository;
import com.baoanh.selfpasswordmanagement.request.LoginRequest;
import com.baoanh.selfpasswordmanagement.request.RegisterRequest;
import com.baoanh.selfpasswordmanagement.response.customer.AuthData;
import com.baoanh.selfpasswordmanagement.services.JwtService;
import com.baoanh.selfpasswordmanagement.services.UserService;
import java.util.HashMap;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserPostGreRepository userPostGreRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthData login(LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassWord()
            )
        );
        User user = userPostGreRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST.value(), "User is not registered"));
        var extraClaims = new HashMap<String, Object>();
        var jwtToken = jwtService.generateToken(extraClaims, user);
        return AuthData.builder()
            .id(user.getId())
            .accessToken(jwtToken)
            .build();
    }

    @Override
    public AuthData register(RegisterRequest request) {
        Optional<User> user = userPostGreRepository.findByEmail(request.getEmail());
        if(user.isPresent()) {
            throw new CustomException(HttpStatus.BAD_REQUEST.value(), "user already exist");
        }

        var registerUser = User.builder().email(request.getEmail())
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassWord()))
            .isActivated(false)
            .role(Role.ADMIN)
            .build();
        var extraClaims = new HashMap<String, Object>();
        var jwtToken = jwtService.generateToken(extraClaims, registerUser);
        userPostGreRepository.save(registerUser);

        return AuthData.builder()
                        .accessToken(jwtToken)
                        .build();

    }
}
