package com.baoanh.selfpasswordmanagement.repository.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "secret_key")
public class SigningKey {
    @Id
    @GeneratedValue
    private Integer id;
    private String key;
}
