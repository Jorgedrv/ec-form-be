package com.esperanzachurch.be.ecformbe.rest;

import com.esperanzachurch.be.ecformbe.application.domain.business.JwtRequest;
import com.esperanzachurch.be.ecformbe.application.domain.business.Token;
import com.esperanzachurch.be.ecformbe.application.facade.JwtFacade;
import com.esperanzachurch.be.ecformbe.shared.logger.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class LoginController {

    private final JwtFacade jwtFacade;

    @Loggable
    @PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Token> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) {
        return ResponseEntity.ok(jwtFacade.loadUserByUsernameAndPassword(jwtRequest));
    }
}
