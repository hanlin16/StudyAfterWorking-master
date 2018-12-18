package com.liuxd.testAop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 切面
 */
@Aspect
@Component
public class MysAspect {

    @Pointcut("@annotation(com.liuxd.testAop.MyAnotation)")
    public void annotationPointCut() {
        System.out.println("annotationPointCut");
    }

    @Before("annotationPointCut()")
    public void beforeAnotation(JoinPoint joinPoint) {
        System.out.println("注解式拦截前置切面开始处理,打印请求参数");
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();

        for (int i = 0; i < paramNames.length; i++) {
            System.out.println(paramNames[i] + "：" + paramValues[i]);
        }
        System.out.println("注解式拦截前置切面操作结束。");

    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MyAnotation myAnotation = method.getAnnotation(MyAnotation.class);
        System.out.println("注解式拦截后置切面：" + myAnotation.name());
    }

    @Before("execution(* com.liuxd.testAop.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截，前置切面，方法名：" + method.getName());
    }
}
