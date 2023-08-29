package com.esperanzachurch.be.ecformbe.application.facade.spanishForm;

import com.esperanzachurch.be.ecformbe.application.domain.business.SpanishFormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.SpanishForm;

public interface SpanishCreateFacade {

    SpanishForm create(final SpanishFormRequest spanishFormRequest);
}
