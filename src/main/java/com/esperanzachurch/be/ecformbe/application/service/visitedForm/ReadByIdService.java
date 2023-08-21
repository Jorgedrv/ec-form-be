package com.esperanzachurch.be.ecformbe.application.service.visitedForm;

import com.esperanzachurch.be.ecformbe.application.domain.entity.Form;
import com.esperanzachurch.be.ecformbe.application.facade.ReadByIdFacade;
import com.esperanzachurch.be.ecformbe.application.facade.ReadFacade;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.NotFoundException;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.PersistenceException;
import com.esperanzachurch.be.ecformbe.infrastructure.repository.FormDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadByIdService implements ReadByIdFacade {

    private final FormDAO formDAO;

    @Override
    public Form read(Long id) {
        try {
            return formDAO.findById(id).get();
        } catch (Exception ex) {
            throw new NotFoundException("404 - " + ex.getMessage(), ex);
        }
    }
}
