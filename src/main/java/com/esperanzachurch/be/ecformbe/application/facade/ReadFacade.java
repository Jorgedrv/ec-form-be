package com.esperanzachurch.be.ecformbe.application.facade;

import com.esperanzachurch.be.ecformbe.application.domain.entity.Form;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReadFacade {

    Page<Form> read(Integer page, Integer size);
}
