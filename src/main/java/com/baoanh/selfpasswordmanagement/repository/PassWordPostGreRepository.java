package com.baoanh.selfpasswordmanagement.repository;

import com.baoanh.selfpasswordmanagement.repository.dto.password.PassWord;
import com.baoanh.selfpasswordmanagement.response.password.PasswordDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassWordPostGreRepository extends JpaRepository<PassWord, Integer> {

    List<PassWord> findAllByUserName(String username, Pageable pageable);
    List<PassWord> findAllByUserNameAndCategoryId(String username, String categoryId, Pageable pageable);
}
