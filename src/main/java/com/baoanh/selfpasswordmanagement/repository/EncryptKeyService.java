package com.baoanh.selfpasswordmanagement.repository;

import com.baoanh.selfpasswordmanagement.repository.dto.SigningKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EncryptKeyService extends JpaRepository<SigningKey, Integer> {

    Optional<SigningKey> findById(Integer id);
}
