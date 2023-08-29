package com.esperanzachurch.be.ecformbe.rest;

import com.esperanzachurch.be.ecformbe.application.domain.business.VisitedFormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.VisitedForm;
import com.esperanzachurch.be.ecformbe.application.facade.visitedForm.VisitedCreateFacade;
import com.esperanzachurch.be.ecformbe.application.facade.visitedForm.VisitedReadByIdFacade;
import com.esperanzachurch.be.ecformbe.application.facade.visitedForm.VisitedReadFacade;
import com.esperanzachurch.be.ecformbe.shared.logger.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("form")
@RequiredArgsConstructor
public class VisitedFormController {

    private final VisitedCreateFacade visitedCreateFacade;
    private final VisitedReadFacade visitedReadFacade;
    private final VisitedReadByIdFacade visitedReadByIdFacade;

    @Loggable
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VisitedForm> create(@RequestBody VisitedFormRequest visitedFormRequest) {
        return ResponseEntity.ok(visitedCreateFacade.create(visitedFormRequest));
    }

    @Loggable
    @GetMapping(value = "read")
    public ResponseEntity<Page<VisitedForm>> read(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(visitedReadFacade.read(page, size));
    }

    @Loggable
    @GetMapping(value = "read/{id}")
    public ResponseEntity<VisitedForm> read(@PathVariable Long id) {
        return ResponseEntity.ok(visitedReadByIdFacade.read(id));
    }
}
