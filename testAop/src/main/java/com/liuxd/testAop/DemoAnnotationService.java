package com.liuxd.testAop;

import org.springframework.stereotype.Service;

/**
 * 业务类
 */
@Service
public class DemoAnnotationService {

    @MyAnotation(name = "注解式拦截的add操作")
    public void add(String params) {
        System.out.println("真正执行到了DemoAnnotationService的add方法,"+params);
    }
}
