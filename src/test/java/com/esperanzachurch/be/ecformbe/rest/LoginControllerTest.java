package com.esperanzachurch.be.ecformbe.rest;

import com.esperanzachurch.be.ecformbe.application.domain.business.JwtRequest;
import com.esperanzachurch.be.ecformbe.application.domain.business.Token;
import com.esperanzachurch.be.ecformbe.application.domain.entity.User;
import com.esperanzachurch.be.ecformbe.application.facade.JwtFacade;
import com.esperanzachurch.be.ecformbe.shared.util.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    @Mock
    JwtFacade jwtFacade;

    @InjectMocks
    LoginController loginController;

    @Test
    void loginController() {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        ReflectionTestUtils.setField(jwtTokenUtil, "SECRET", "javatokenlocal");

        User user = new User();
        user.setUsername("javauser");
        user.setPassword("1234");
        user.setRole("ADMIN");

        String token = jwtTokenUtil.generateToken(user);
        JwtRequest jwtRequest = new JwtRequest("javauser", "1234");
        when(jwtFacade.loadUserByUsernameAndPassword(jwtRequest)).thenReturn(new Token(token));

        ResponseEntity<Token> response = loginController.createAuthenticationToken(jwtRequest);

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole())));

        assertTrue(jwtTokenUtil.validateToken(response.getBody().getToken(), userDetails));
    }
}
