package com.baoanh.selfpasswordmanagement.controllers;

import com.baoanh.selfpasswordmanagement.response.password.PasswordDto;
import com.baoanh.selfpasswordmanagement.services.PasswordService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/password")
@RequiredArgsConstructor
public class PassWordController {

    private final PasswordService passwordService;

    @GetMapping("/list")
    public List<PasswordDto> getListPassWord(@RequestParam String email,
        @RequestParam(required = false, defaultValue = "1") int page,
        @RequestParam(required = false, defaultValue = "10") int size) {
        return passwordService.getListPasswords(email, page, size);
    }
}
