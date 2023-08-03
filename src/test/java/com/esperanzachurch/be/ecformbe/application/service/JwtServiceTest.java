package com.esperanzachurch.be.ecformbe.application.service;

import com.esperanzachurch.be.ecformbe.application.domain.business.JwtRequest;
import com.esperanzachurch.be.ecformbe.application.domain.business.Token;
import com.esperanzachurch.be.ecformbe.application.domain.entity.User;
import com.esperanzachurch.be.ecformbe.infrastructure.exception.AccessException;
import com.esperanzachurch.be.ecformbe.infrastructure.repository.UserDAO;
import com.esperanzachurch.be.ecformbe.shared.util.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class JwtServiceTest {

    @Mock
    JwtTokenUtil jwtTokenUtilMock;

    @Mock
    UserDAO userDAO;

    @InjectMocks
    JwtService jwtService;

    @Test
    void loadUserByUsernameAndPasswordShouldReturnToken() {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        ReflectionTestUtils.setField(jwtTokenUtil, "SECRET", "javatokenlocal");

        JwtRequest jwtRequest = new JwtRequest("javauser", "1234");
        User user = new User();
        user.setUsername("javauser");
        user.setPassword("1234");
        user.setRole("ADMIN");

        String token = jwtTokenUtil.generateToken(user);

        when(userDAO.findUserByUsernameAndPassword(jwtRequest.getUsername(), jwtRequest.getPassword()))
                .thenReturn(user);
        when(jwtTokenUtilMock.generateToken(user)).thenReturn(token);

        Token response = jwtService.loadUserByUsernameAndPassword(jwtRequest);
        assertEquals(response.getToken(), token);
    }

    @Test
    void loadUserByUsernameAndPasswordShouldThrowException() {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        ReflectionTestUtils.setField(jwtTokenUtil, "SECRET", "javatokenlocal");

        JwtRequest jwtRequest = new JwtRequest("javauser", "1234");

        when(userDAO.findUserByUsernameAndPassword(jwtRequest.getUsername(), jwtRequest.getPassword()))
                .thenReturn(null);
        assertThrows(AccessException.class, () -> jwtService.loadUserByUsernameAndPassword(jwtRequest));
    }

    @Test
    void loadUserByUsernameShouldReturnToken() {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        ReflectionTestUtils.setField(jwtTokenUtil, "SECRET", "javatokenlocal");

        JwtRequest jwtRequest = new JwtRequest("javauser", "1234");
        User user = new User();
        user.setUsername("javauser");
        user.setPassword("1234");
        user.setRole("ADMIN");

        when(userDAO.findUserByUsername(jwtRequest.getUsername())).thenReturn(user);

        UserDetails userDetails = jwtService.loadUserByUsername("javauser");
        assertEquals(userDetails.getUsername(), user.getUsername());
        assertEquals(userDetails.getPassword(), user.getPassword());
    }

    @Test
    void loadUserByUsernameShouldThrowException() {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        ReflectionTestUtils.setField(jwtTokenUtil, "SECRET", "javatokenlocal");

        JwtRequest jwtRequest = new JwtRequest("javauser", "1234");

        when(userDAO.findUserByUsername(jwtRequest.getUsername()))
                .thenReturn(null);
        assertThrows(AccessException.class, () -> jwtService.loadUserByUsername("javauser"));
    }
}
