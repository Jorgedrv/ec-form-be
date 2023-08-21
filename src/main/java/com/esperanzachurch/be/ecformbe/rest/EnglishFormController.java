package com.esperanzachurch.be.ecformbe.rest;

import com.esperanzachurch.be.ecformbe.application.domain.business.EnglishFormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.EnglishForm;
import com.esperanzachurch.be.ecformbe.application.facade.englishForm.EnglishCreateFacade;
import com.esperanzachurch.be.ecformbe.shared.logger.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("english-form")
@RequiredArgsConstructor
public class EnglishFormController {

    private final EnglishCreateFacade englishCreateFacade;

    @Loggable
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnglishForm> create(@RequestBody EnglishFormRequest englishFormRequest) {
        return ResponseEntity.ok(englishCreateFacade.create(englishFormRequest));
    }
}
