package com.supermario.mixsuper.aspects;


import com.supermario.mixsuper.wrapper.LogTrace;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@Aspect
@Component
@Order(1)
public class WebLogAespect {

    private static Logger LOGGER = LoggerFactory.getLogger(WebLogAespect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution (* com.supermario.mixsuper.controller..*.*(..))")
    public void executeService(){}


    @Before("executeService()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        LOGGER.info("Enter the executeService aspect.");
        // Record the start time
        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LogTrace logTrace = recordLogTrace(request, joinPoint);
        LOGGER.info(logTrace.toString());

    }

    @AfterReturning(returning = "response", pointcut = "executeService()")
    public void doAfterReturning(Object response) throws Throwable {
        LOGGER.info("response: {}", response);
        LOGGER.info("cost time: {}", System.currentTimeMillis() - startTime.get());
    }

    /**
     * Build a logtrace
     * @param request httpservletrequest
     * @param joinPoint joinpoint
     * @return LogTrace
     */
    private LogTrace recordLogTrace(HttpServletRequest request, JoinPoint joinPoint) {
        LogTrace logTrace = LogTrace.builder()
                .requestUri(request.getRequestURI())
                .requestUrl(request.getRequestURL().toString())
                .queryString(request.getQueryString())
                .remoteAddress(request.getRemoteAddr())
                .remoteHost(request.getRemoteHost())
                .remotePort(String.valueOf(request.getRemotePort()))
                .localAddress(request.getLocalAddr())
                .localName(request.getLocalName())
                .method(request.getMethod())
                .headers(getHeaderInfo(request))
                .parameters(request.getParameterMap())
                .classMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName())
                .args(Arrays.toString(joinPoint.getArgs())).build();

        return logTrace;

    }

    /**
     * Get the header info
     * @param request request
     * @return map
     */
    private Map getHeaderInfo(HttpServletRequest request) {
        Map<String, String> headerInfo = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            headerInfo.put(key, value);
        }
        return headerInfo;
    }


}
