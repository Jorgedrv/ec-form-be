package com.esperanzachurch.be.ecformbe.application.service;

import com.esperanzachurch.be.ecformbe.application.domain.business.FormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.Form;
import com.esperanzachurch.be.ecformbe.application.facade.CreateFacade;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.PersistenceException;
import com.esperanzachurch.be.ecformbe.infrastructure.factory.FormFactory;
import com.esperanzachurch.be.ecformbe.infrastructure.repository.FormDAO;
import com.esperanzachurch.be.ecformbe.shared.logger.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateService implements CreateFacade {

    private final FormDAO formDAO;

    @Loggable
    @Override
    public Form create(final FormRequest formRequest) {
        try {
            return formDAO.save(FormFactory.formConverter(formRequest));
        } catch (Exception ex) {
            throw new PersistenceException(ex);
        }
    }
}
