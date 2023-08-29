package com.esperanzachurch.be.ecformbe.application.service.spanishForm;

import com.esperanzachurch.be.ecformbe.application.domain.business.SpanishFormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.SpanishForm;
import com.esperanzachurch.be.ecformbe.application.facade.spanishForm.SpanishCreateFacade;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.PersistenceException;
import com.esperanzachurch.be.ecformbe.infrastructure.factory.SpanishFormFactory;
import com.esperanzachurch.be.ecformbe.infrastructure.repository.SpanishFormDAO;
import com.esperanzachurch.be.ecformbe.shared.logger.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SpanishCreateService implements SpanishCreateFacade {

    private final SpanishFormDAO spanishFormDAO;

    @Loggable
    @Override
    @Transactional
    public SpanishForm create(final SpanishFormRequest spanishFormRequest) {
        try {
            return spanishFormDAO.save(SpanishFormFactory.formConverter(spanishFormRequest));
        } catch (Exception ex) {
            throw new PersistenceException(ex);
        }
    }
}
