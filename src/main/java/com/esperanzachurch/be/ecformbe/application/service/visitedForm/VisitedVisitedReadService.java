package com.esperanzachurch.be.ecformbe.application.service.visitedForm;

import com.esperanzachurch.be.ecformbe.application.domain.entity.VisitedForm;
import com.esperanzachurch.be.ecformbe.application.facade.visitedForm.VisitedReadFacade;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.PersistenceException;
import com.esperanzachurch.be.ecformbe.infrastructure.repository.VisitedFormDAO;
import com.esperanzachurch.be.ecformbe.shared.logger.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitedVisitedReadService implements VisitedReadFacade {

    private final VisitedFormDAO visitedFormDAO;

    @Override
    @Loggable
    public Page<VisitedForm> read(Integer page, Integer size) {
        try {
            Pageable paging = PageRequest.of(page, size);
            return visitedFormDAO.findAll(paging);
        } catch (Exception ex) {
            throw new PersistenceException("500 " + ex.getMessage(), ex);
        }
    }
}
