package com.esperanzachurch.be.ecformbe.infrastructure.repository;

import com.esperanzachurch.be.ecformbe.application.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
    User findUserByUsernameAndPassword(String username, String password);
}
