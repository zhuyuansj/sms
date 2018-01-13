package com.paic.loancloud.sms.filter;

import com.paic.loancloud.sms.util.MDCUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sunjian on 2017/4/2.
 */
@Aspect//是执行切入点，也就是在类上面用@Aspect@Component,下面的方法就能用@Before,@After这种了
@Component//是组件不好归类的时候使用
public class WebHeaderAspect {
    @Pointcut("execution(public * com.paic.loancloud.sms.web.*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws  Throwable{
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes == null){
            System.out.println("cannot get request");
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        String username = request.getHeader(MDCUtil.MDC_USERNAME);
        if(StringUtils.isBlank(username)){
            username = "";
        }
        String transactionId = request.getHeader(MDCUtil.MDC_TRANSACTION_ID);
        if(StringUtils.isBlank(transactionId)){
            transactionId = "";
        }
        MDCUtil.setUsername(username);
        MDCUtil.setTransactionId(transactionId);
    }





    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable{
        //处理完请求，返回内容
        System.out.println("RESPONSE : "+ret);
    }





}
