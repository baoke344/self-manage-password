package com.baoanh.selfpasswordmanagement.controllers;

import com.baoanh.selfpasswordmanagement.request.LoginRequest;
import com.baoanh.selfpasswordmanagement.response.customer.AuthData;
import com.baoanh.selfpasswordmanagement.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;
    @PostMapping
    public AuthData login(@RequestBody LoginRequest request) {
        return userService.login(request);

    }
}
