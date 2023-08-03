package com.esperanzachurch.be.ecformbe.shared.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggableAspect {

    public static final String REQUEST = "[Request] -> ";
    public static final String RESPONSE = "[Response] -> ";
    public static final String EXCEPTION = "[Exception] -> ";

    @Around("@annotation(Loggable)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        final Signature signature = joinPoint.getSignature();
        Logger logger = LogManager.getLogger(signature.getDeclaringType());
        Arrays.stream(joinPoint.getArgs()).forEach(log -> {
            logger.info(signature.getName() + REQUEST + log);
        });
        return joinPoint.proceed();
    }

    @AfterReturning(value = "@annotation(Loggable)", returning = "object")
    public void afterReturning(JoinPoint joinPoint, Object object) {
        final Signature signature = joinPoint.getSignature();
        Logger logger = LogManager.getLogger(signature.getDeclaringType());
        logger.info(signature.getName() + RESPONSE + object);
    }

    @AfterThrowing(value = "execution(* com.esperanzachurch.be.ecformbe.application.service.*.*(..))",
            throwing="ex")
    public void afterReturning(JoinPoint joinPoint, Exception ex) throws Exception {
        final Signature signature = joinPoint.getSignature();
        Logger logger = LogManager.getLogger(signature.getDeclaringType());
        logger.error(signature.getName() + EXCEPTION + ex);
        logger.error(ex);
        throw new Exception(ex.getMessage());
    }

}
