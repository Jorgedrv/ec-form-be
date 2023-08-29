package com.esperanzachurch.be.ecformbe.application.facade.visitedForm;

import com.esperanzachurch.be.ecformbe.application.domain.entity.VisitedForm;
import org.springframework.data.domain.Page;

public interface VisitedReadFacade {

    Page<VisitedForm> read(Integer page, Integer size);
}
