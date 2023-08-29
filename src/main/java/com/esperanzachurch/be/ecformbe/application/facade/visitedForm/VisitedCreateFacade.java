package com.esperanzachurch.be.ecformbe.application.facade.visitedForm;

import com.esperanzachurch.be.ecformbe.application.domain.business.VisitedFormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.VisitedForm;

public interface VisitedCreateFacade {

    VisitedForm create(final VisitedFormRequest visitedFormRequest);
}
