package com.baoanh.selfpasswordmanagement.services.impl;

import com.baoanh.selfpasswordmanagement.repository.dto.User;
import com.baoanh.selfpasswordmanagement.exception.CustomException;
import com.baoanh.selfpasswordmanagement.repository.PostGreRepository;
import com.baoanh.selfpasswordmanagement.request.LoginRequest;
import com.baoanh.selfpasswordmanagement.request.RegisterRequest;
import com.baoanh.selfpasswordmanagement.response.AuthData;
import com.baoanh.selfpasswordmanagement.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final PostGreRepository postGreRepository;

    @Override
    public AuthData login(LoginRequest request) {
        AuthData authData = new AuthData();

        return authData;
    }

    @Override
    public String register(RegisterRequest request) {
        Optional<User> user = postGreRepository.findByEmail(request.getEmail());
        if(user.isPresent()) {
            throw new CustomException(HttpStatus.BAD_REQUEST.value(), "user already exist");
        }

        User registerUser = new User();
        registerUser.setEmail(request.getEmail());
        registerUser.setFirstName(request.getFirstName());
        registerUser.setPassword(request.getPassWord());
        registerUser.setLastName(request.getLastName());
        registerUser.setActivated(false);
        postGreRepository.save(registerUser);

        return "Register Successful! Waiting for account to be activate";

    }
}
