package com.makeronly.common.aop;

import com.makeronly.common.util.Network;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 用户日志切面
 * @author Walter Wong
 */
@Component
@Aspect
@Order(1)
public class UserLogAspect {
    private static final Logger log = LoggerFactory.getLogger(UserLogAspect.class);

    private HttpServletRequest request;

    @Autowired
    public UserLogAspect(HttpServletRequest request) {
        this.request = request;
    }

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.makeronly.*.resource.*.*(..))")
    public void execute() {}

    @Before("execute()")
    public void executeBefore(JoinPoint jp) {
        startTime.set(System.currentTimeMillis());
        log.info("Request URL : {}", request.getRequestURL());
        log.info("Request Method : {}",request.getMethod());
        log.info("Host : {}", Network.getHost(request));
        log.info("Class : {}",jp.getSignature().getDeclaringType());
        log.info("Method : {}",jp.getSignature().getName());
        log.info("Args : {}", Arrays.toString(jp.getArgs()));
    }

    @AfterReturning(returning = "r", pointcut = "execute()")
    public void executeAfterReturning(Object r) {
        log.info("返回 : {}",r);
        log.info("耗时 :{} ms",(System.currentTimeMillis() - startTime.get()));
    }
}
