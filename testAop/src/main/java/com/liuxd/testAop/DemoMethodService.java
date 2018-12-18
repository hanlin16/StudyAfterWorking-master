package com.liuxd.testAop;

import org.springframework.stereotype.Service;

/**
 * 业务类
 */
@Service
public class DemoMethodService {
    public void add() {
        System.out.println("执行DemoMethodService.add()");
    }
}
