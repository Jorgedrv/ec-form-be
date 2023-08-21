package com.esperanzachurch.be.ecformbe.application.service.englishForm;

import com.esperanzachurch.be.ecformbe.application.domain.business.EnglishFormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.EnglishForm;
import com.esperanzachurch.be.ecformbe.application.facade.englishForm.EnglishCreateFacade;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.PersistenceException;
import com.esperanzachurch.be.ecformbe.infrastructure.factory.EnglishFormFactory;
import com.esperanzachurch.be.ecformbe.infrastructure.repository.EnglishFormDAO;
import com.esperanzachurch.be.ecformbe.shared.logger.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnglishCreateService implements EnglishCreateFacade {

    private final EnglishFormDAO englishFormDAO;

    @Loggable
    @Override
    public EnglishForm create(final EnglishFormRequest englishFormRequest) {
        try {
            return englishFormDAO.save(EnglishFormFactory.formConverter(englishFormRequest));
        } catch (Exception ex) {
            throw new PersistenceException(ex);
        }
    }
}
