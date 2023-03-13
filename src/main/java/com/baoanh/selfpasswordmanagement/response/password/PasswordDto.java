package com.baoanh.selfpasswordmanagement.response.password;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordDto {

  private String url;
  private String userName;
  private String password;
}
