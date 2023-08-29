package com.esperanzachurch.be.ecformbe.rest;

import com.esperanzachurch.be.ecformbe.application.domain.business.SpanishFormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.SpanishForm;
import com.esperanzachurch.be.ecformbe.application.facade.spanishForm.SpanishCreateFacade;
import com.esperanzachurch.be.ecformbe.shared.logger.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("spanish-form")
@RequiredArgsConstructor
public class SpanishFormController {

    private final SpanishCreateFacade spanishCreateFacade;

    @Loggable
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpanishForm> create(@RequestBody SpanishFormRequest spanishFormRequest) {
        return ResponseEntity.ok(spanishCreateFacade.create(spanishFormRequest));
    }
}
