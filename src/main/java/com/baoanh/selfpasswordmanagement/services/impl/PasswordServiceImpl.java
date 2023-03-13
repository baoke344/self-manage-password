package com.baoanh.selfpasswordmanagement.services.impl;

import com.baoanh.selfpasswordmanagement.response.password.PasswordDto;
import com.baoanh.selfpasswordmanagement.services.PasswordService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {


  @Override
  public List<PasswordDto> getListPasswords(String email, int pageSize, int pageNumber) {

    return null;
  }
}
