package com.esperanzachurch.be.ecformbe.infrastructure.repository;

import com.esperanzachurch.be.ecformbe.application.domain.entity.SpanishForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpanishFormDAO extends JpaRepository<SpanishForm, Long> {
}
