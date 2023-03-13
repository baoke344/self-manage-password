package com.baoanh.selfpasswordmanagement.repository;

import com.baoanh.selfpasswordmanagement.repository.dto.password.PassWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassWordPostGreRepository extends JpaRepository<PassWord, Integer> {

}
