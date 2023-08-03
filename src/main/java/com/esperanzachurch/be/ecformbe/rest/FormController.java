package com.esperanzachurch.be.ecformbe.rest;

import com.esperanzachurch.be.ecformbe.application.domain.business.FormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.Form;
import com.esperanzachurch.be.ecformbe.application.facade.CreateFacade;
import com.esperanzachurch.be.ecformbe.application.facade.ReadByIdFacade;
import com.esperanzachurch.be.ecformbe.application.facade.ReadFacade;
import com.esperanzachurch.be.ecformbe.shared.logger.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("form")
@RequiredArgsConstructor
public class FormController {

    private final CreateFacade createFacade;
    private final ReadFacade readFacade;
    private final ReadByIdFacade readByIdFacade;

    @Loggable
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Form> create(@RequestBody FormRequest formRequest) {
        return ResponseEntity.ok(createFacade.create(formRequest));
    }

    @Loggable
    @GetMapping(value = "read")
    public ResponseEntity<Page<Form>> read(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(readFacade.read(page, size));
    }

    @Loggable
    @GetMapping(value = "read/{id}")
    public ResponseEntity<Form> read(@PathVariable Long id) {
        return ResponseEntity.ok(readByIdFacade.read(id));
    }
}
