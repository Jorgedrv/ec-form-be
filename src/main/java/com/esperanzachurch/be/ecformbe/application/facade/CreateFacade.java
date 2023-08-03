package com.esperanzachurch.be.ecformbe.application.facade;

import com.esperanzachurch.be.ecformbe.application.domain.business.FormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.Form;

public interface CreateFacade {

    Form create(final FormRequest formRequest);
}
