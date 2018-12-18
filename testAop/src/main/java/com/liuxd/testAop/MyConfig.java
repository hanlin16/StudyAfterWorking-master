package com.liuxd.testAop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.liuxd.testAop")
@EnableAspectJAutoProxy
public class MyConfig {

}
