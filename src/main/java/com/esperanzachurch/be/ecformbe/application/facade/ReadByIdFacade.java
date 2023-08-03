package com.esperanzachurch.be.ecformbe.application.facade;

import com.esperanzachurch.be.ecformbe.application.domain.entity.Form;

import java.util.List;

public interface ReadByIdFacade {

    Form read(Long id);
}
