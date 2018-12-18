package com.liuxd.testAop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);

        demoAnnotationService.add("annotation 方式");//基于注解的拦截
        System.out.println("------------------------------");
        demoMethodService.add();//给予方法规则的拦截

        context.close();
        
    }
}
