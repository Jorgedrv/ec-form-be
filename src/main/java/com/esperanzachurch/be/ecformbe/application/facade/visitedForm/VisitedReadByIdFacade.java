package com.esperanzachurch.be.ecformbe.application.facade.visitedForm;

import com.esperanzachurch.be.ecformbe.application.domain.entity.VisitedForm;

public interface VisitedReadByIdFacade {

    VisitedForm read(Long id);
}
