package com.baoanh.selfpasswordmanagement.controllers;

import com.baoanh.selfpasswordmanagement.request.GetListPassWordRequest;
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
    public List<PasswordDto> getListPassWord(@RequestParam(required = false) String email,
                                             @RequestParam(required = false) String categoryId,
                                             @RequestParam(required = false, defaultValue = "1") int page,
                                             @RequestParam(required = false, defaultValue = "10") int size) {
        GetListPassWordRequest request = new GetListPassWordRequest();
        request.setCategoryId(categoryId);
        request.setUsername(email);
        request.setPageNo(page);
        request.setPageSize(size);
        return passwordService.getListPasswords(request);
    }
}
