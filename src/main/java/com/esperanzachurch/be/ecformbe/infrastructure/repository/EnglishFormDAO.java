package com.esperanzachurch.be.ecformbe.infrastructure.repository;

import com.esperanzachurch.be.ecformbe.application.domain.entity.EnglishForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnglishFormDAO extends JpaRepository<EnglishForm, Long> {
}
