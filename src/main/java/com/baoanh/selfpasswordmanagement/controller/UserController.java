package com.baoanh.selfpasswordmanagement.controller;

import com.baoanh.selfpasswordmanagement.request.RegisterRequest;
import com.baoanh.selfpasswordmanagement.response.MakeResponse;
import com.baoanh.selfpasswordmanagement.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public MakeResponse registerUser(@RequestBody RegisterRequest request) {
        String response = userService.register(request);
        return MakeResponse.makeResponse(response);
    }
}
