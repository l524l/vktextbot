package com.l524l.vktextbot.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommandLogAspect {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.l524l.vktextbot.commands.Command.execute(..))")
    public void testasp(){

    }

    @AfterReturning("testasp()")
    public void run(JoinPoint joinPoint){
        LOG.info(joinPoint.getTarget().getClass().getName() + " was executed");
    }
    @AfterThrowing(pointcut = "testasp()", throwing = "ex")
    public void runWithExption(JoinPoint joinPoint, Throwable ex){
        LOG.warn(joinPoint.getTarget().getClass().getName() + " has execution error", ex);
    }

}
