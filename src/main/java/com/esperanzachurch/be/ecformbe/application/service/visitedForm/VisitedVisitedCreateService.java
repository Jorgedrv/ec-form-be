package com.esperanzachurch.be.ecformbe.application.service.visitedForm;

import com.esperanzachurch.be.ecformbe.application.domain.business.VisitedFormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.VisitedForm;
import com.esperanzachurch.be.ecformbe.application.facade.visitedForm.VisitedCreateFacade;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.PersistenceException;
import com.esperanzachurch.be.ecformbe.infrastructure.factory.FormFactory;
import com.esperanzachurch.be.ecformbe.infrastructure.repository.VisitedFormDAO;
import com.esperanzachurch.be.ecformbe.shared.logger.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitedVisitedCreateService implements VisitedCreateFacade {

    private final VisitedFormDAO visitedFormDAO;

    @Loggable
    @Override
    public VisitedForm create(final VisitedFormRequest visitedFormRequest) {
        try {
            return visitedFormDAO.save(FormFactory.formConverter(visitedFormRequest));
        } catch (Exception ex) {
            throw new PersistenceException(ex);
        }
    }
}
