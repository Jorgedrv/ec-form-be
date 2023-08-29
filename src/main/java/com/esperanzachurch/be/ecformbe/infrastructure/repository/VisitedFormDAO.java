package com.esperanzachurch.be.ecformbe.infrastructure.repository;

import com.esperanzachurch.be.ecformbe.application.domain.entity.VisitedForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitedFormDAO extends JpaRepository<VisitedForm, Long> {
}
