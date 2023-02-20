package com.baoanh.selfpasswordmanagement.services;

import com.baoanh.selfpasswordmanagement.request.LoginRequest;
import com.baoanh.selfpasswordmanagement.request.RegisterRequest;
import com.baoanh.selfpasswordmanagement.response.customer.AuthData;

public interface UserService {

    AuthData login(LoginRequest request);
    AuthData register(RegisterRequest request);
}
