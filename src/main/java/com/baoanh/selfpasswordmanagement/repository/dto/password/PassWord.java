package com.baoanh.selfpasswordmanagement.repository.dto.password;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "password")
public class PassWord {

  @Id
  @GeneratedValue
  private Integer id;
  private String userName;
  private String savedPassWord;
  private String url;
  private String name;
  private Date createdDate;
  private Date updatedDate;

}
