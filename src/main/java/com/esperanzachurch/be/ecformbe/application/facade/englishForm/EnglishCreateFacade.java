package com.esperanzachurch.be.ecformbe.application.facade.englishForm;

import com.esperanzachurch.be.ecformbe.application.domain.business.EnglishFormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.EnglishForm;

public interface EnglishCreateFacade {

    EnglishForm create(final EnglishFormRequest englishFormRequest);
}
