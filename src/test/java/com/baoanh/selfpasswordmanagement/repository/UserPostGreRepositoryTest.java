package com.baoanh.selfpasswordmanagement.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.baoanh.selfpasswordmanagement.repository.dto.user.User;
import java.util.Optional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ContextConfiguration(classes = {UserPostGreRepository.class})
//@EnableAutoConfiguration
//@EntityScan(basePackages = {"com.baoanh.selfpasswordmanagement.repository.dto.user"})
//@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
@DataJpaTest
@ExtendWith(SpringExtension.class)
class UserPostGreRepositoryTest {

  @Autowired
  private UserPostGreRepository userPostGreRepository;

  /**
   * Method under test: {@link UserPostGreRepository#findById(Integer)}
   */
  @Test
  void testFindById() {

    Integer integer = 302;

    // Act
    Optional<User> actualFindByIdResult = this.userPostGreRepository.findById(integer);
    User user = actualFindByIdResult.orElse(null);
    // Assert
    assertNotNull(user);
  }

}