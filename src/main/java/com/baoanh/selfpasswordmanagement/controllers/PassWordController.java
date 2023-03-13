package com.baoanh.selfpasswordmanagement.controllers;

import com.baoanh.selfpasswordmanagement.services.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/password")
@RequiredArgsConstructor
public class PassWordController {

    private final PasswordService passwordService;

    @GetMapping("/list")
    public String getListPassWord() {
        return "A";
    }
}
