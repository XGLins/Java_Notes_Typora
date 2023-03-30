package com.hnsm.spring.proxy;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator{

    @Override
    public int add(int i, int j) {
//        System.out.println("日志：方法：add，参数："+i+","+j);
        int result = i + j;
        System.out.println("方法内部，result：" + result);
//        System.out.println("日志：方法：add，参数：" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
//        System.out.println("日志：方法：sub，参数："+i+","+j);
        int result = i - j;
        System.out.println("方法内部，result：" + result);
//        System.out.println("日志：方法：sub，参数：" + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
//        System.out.println("日志：方法：mul，参数："+i+","+j);
        int result = i * j;
        System.out.println("方法内部，result：" + result);
//        System.out.println("日志：方法：mul，参数：" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
//        System.out.println("日志：方法：div，参数："+i+","+j);
        int result = i / j;
        System.out.println("方法内部，result：" + result);
//        System.out.println("日志：方法：div，参数：" + result);
        return result;
    }
}
