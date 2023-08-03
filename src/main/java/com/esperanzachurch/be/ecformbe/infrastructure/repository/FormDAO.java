package com.esperanzachurch.be.ecformbe.infrastructure.repository;

import com.esperanzachurch.be.ecformbe.application.domain.entity.Form;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormDAO extends JpaRepository<Form, Long> {
}
