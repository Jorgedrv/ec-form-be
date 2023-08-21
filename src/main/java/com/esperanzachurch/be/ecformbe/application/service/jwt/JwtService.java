package com.esperanzachurch.be.ecformbe.application.service.jwt;

import com.esperanzachurch.be.ecformbe.application.domain.business.JwtRequest;
import com.esperanzachurch.be.ecformbe.application.domain.business.Token;
import com.esperanzachurch.be.ecformbe.application.domain.entity.User;
import com.esperanzachurch.be.ecformbe.application.facade.JwtFacade;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.AccessException;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.PersistenceException;
import com.esperanzachurch.be.ecformbe.infrastructure.repository.UserDAO;
import com.esperanzachurch.be.ecformbe.shared.logger.Loggable;
import com.esperanzachurch.be.ecformbe.shared.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class JwtService implements JwtFacade {

    private final UserDAO userDAO;

    private final JwtTokenUtil jwtTokenUtil;

    @Loggable
    @Override
    public Token loadUserByUsernameAndPassword(JwtRequest jwtRequest) {
        User user = userDAO.findUserByUsernameAndPassword(jwtRequest.getUsername(), jwtRequest.getPassword());
        if (user == null) {
            throw new AccessException("401 - User not found");
        }
        final String token = jwtTokenUtil.generateToken(user);
        return new Token(token);
    }

    @Loggable
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userDAO.findUserByUsername(username);
        if (user == null) {
            throw new AccessException("401 - User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
    }
}
