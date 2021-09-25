package com.l524l.vktextbot.aspects;

import com.l524l.vktextbot.annotations.SecureCommand;
import com.l524l.vktextbot.commands.Command;
import com.l524l.vktextbot.user.User;
import com.l524l.vktextbot.user.UserRole;
import com.l524l.vktextbot.vk.VkDataSender;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommandSecureAspect {

    private final VkDataSender dataSender;

    @Autowired
    public CommandSecureAspect(VkDataSender dataSender) {
        this.dataSender = dataSender;
    }

    @Pointcut("execution(* com.l524l.vktextbot.commands.Command.execute(..)) && @within(com.l524l.vktextbot.annotations.SecureCommand)")
    public void secureCommand(){

    }

    @Around("secureCommand()")
    public void secure(ProceedingJoinPoint joinPoint) throws Throwable {
        Command command = (Command) joinPoint.getTarget();

        UserRole[] requiredAuthorities = command.getClass()
                                                .getAnnotation(SecureCommand.class)
                                                .authorities();

        User user = command.getExecutor();

        for (UserRole role :
                requiredAuthorities) {

            if (user.hasRole(role)) {
                joinPoint.proceed();
                return;
            }
        }

        dataSender.sendMessage("Недостаточно прав для выполнения команды", user);
    }
}
