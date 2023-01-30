package com.baoanh.selfpasswordmanagement.services.impl;

import com.baoanh.selfpasswordmanagement.repository.dto.Role;
import com.baoanh.selfpasswordmanagement.repository.dto.User;
import com.baoanh.selfpasswordmanagement.exception.CustomException;
import com.baoanh.selfpasswordmanagement.repository.PostGreRepository;
import com.baoanh.selfpasswordmanagement.request.LoginRequest;
import com.baoanh.selfpasswordmanagement.request.RegisterRequest;
import com.baoanh.selfpasswordmanagement.response.AuthData;
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

    private final PostGreRepository postGreRepository;
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
        User user = postGreRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST.value(), "User is not registered"));
        var extraClaims = new HashMap<String, Object>();
        var jwtToken = jwtService.generateToken(extraClaims, user);
        return new AuthData();
    }

    @Override
    public String register(RegisterRequest request) {
        Optional<User> user = postGreRepository.findByEmail(request.getEmail());
        if(user.isPresent()) {
            throw new CustomException(HttpStatus.BAD_REQUEST.value(), "user already exist");
        }

        var registerUser = User.builder().email(request.getEmail())
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassWord()))
            .isActivated(false)
            .role(Role.USER)
            .build();
        var extraClaims = new HashMap<String, Object>();
        var jwtToken = jwtService.generateToken(extraClaims, registerUser);
        postGreRepository.save(registerUser);

        return "Register Successful! Waiting for account to be activate";

    }
}
