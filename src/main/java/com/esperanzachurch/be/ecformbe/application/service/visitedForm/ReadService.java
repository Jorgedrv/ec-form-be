package com.esperanzachurch.be.ecformbe.application.service.visitedForm;

import com.esperanzachurch.be.ecformbe.application.domain.entity.Form;
import com.esperanzachurch.be.ecformbe.application.facade.ReadFacade;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.NotFoundException;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.PersistenceException;
import com.esperanzachurch.be.ecformbe.infrastructure.repository.FormDAO;
import com.esperanzachurch.be.ecformbe.shared.logger.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadService implements ReadFacade {

    private final FormDAO formDAO;

    @Override
    @Loggable
    public Page<Form> read(Integer page, Integer size) {
        try {
            Pageable paging = PageRequest.of(page, size);
            return formDAO.findAll(paging);
        } catch (Exception ex) {
            throw new PersistenceException("500 " + ex.getMessage(), ex);
        }
    }
}
