package com.esperanzachurch.be.ecformbe.application.facade;

import com.esperanzachurch.be.ecformbe.application.domain.business.JwtRequest;
import com.esperanzachurch.be.ecformbe.application.domain.business.Token;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtFacade {

    Token loadUserByUsernameAndPassword(JwtRequest jwtRequest);

    UserDetails loadUserByUsername(String username);
}
