package com.baoanh.selfpasswordmanagement.response.password;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PasswordDto {

  private Integer id;
  private String userName;
  private String savedPassWord;
  private String url;
  private String name;
  private Date createdDate;
  private Date updatedDate;
}
