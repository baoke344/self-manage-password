package com.baoanh.selfpasswordmanagement.services;

import com.baoanh.selfpasswordmanagement.request.GetListPassWordRequest;
import com.baoanh.selfpasswordmanagement.response.password.PasswordDto;
import java.util.List;

public interface PasswordService {

  List<PasswordDto> getListPasswords(GetListPassWordRequest request);
}
