package com.baoanh.selfpasswordmanagement.repository;

import com.baoanh.selfpasswordmanagement.repository.dto.user.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostGreRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(@NonNull Integer id);
    Optional<User> findByEmail(@NonNull String email);
}
