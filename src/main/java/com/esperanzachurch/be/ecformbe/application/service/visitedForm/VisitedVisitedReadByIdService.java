package com.esperanzachurch.be.ecformbe.application.service.visitedForm;

import com.esperanzachurch.be.ecformbe.application.domain.entity.VisitedForm;
import com.esperanzachurch.be.ecformbe.application.facade.visitedForm.VisitedReadByIdFacade;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.NotFoundException;
import com.esperanzachurch.be.ecformbe.infrastructure.repository.VisitedFormDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitedVisitedReadByIdService implements VisitedReadByIdFacade {

    private final VisitedFormDAO visitedFormDAO;

    @Override
    public VisitedForm read(Long id) {
        try {
            return visitedFormDAO.findById(id).get();
        } catch (Exception ex) {
            throw new NotFoundException("404 - " + ex.getMessage(), ex);
        }
    }
}
