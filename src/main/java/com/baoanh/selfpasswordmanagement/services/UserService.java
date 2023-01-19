package com.baoanh.selfpasswordmanagement.services;

import com.baoanh.selfpasswordmanagement.request.LoginRequest;
import com.baoanh.selfpasswordmanagement.request.RegisterRequest;
import com.baoanh.selfpasswordmanagement.response.AuthData;

public interface UserService {

    AuthData login(LoginRequest request);
    String register(RegisterRequest request);
}
