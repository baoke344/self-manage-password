package com.baoanh.selfpasswordmanagement.converter;

import com.baoanh.selfpasswordmanagement.repository.dto.password.PassWord;
import com.baoanh.selfpasswordmanagement.response.password.PasswordDto;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class PasswordConverter implements Function<PassWord, PasswordDto> {

  @Override
  public PasswordDto apply(PassWord passWord) {
    return new PasswordDto(passWord.getId(), passWord.getUserName(), passWord.getSavedPassWord(),
        passWord.getUrl(),
        passWord.getName(), passWord.getCreatedDate(), passWord.getUpdatedDate());
  }
}
