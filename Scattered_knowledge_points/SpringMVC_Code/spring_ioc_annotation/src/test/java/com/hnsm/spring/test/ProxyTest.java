package com.hnsm.spring.test;

import com.hnsm.spring.proxy.CalculatorImpl;
import com.hnsm.spring.proxy.CalculatorStaticProxy;
import org.junit.Test;

public class ProxyTest {

    @Test
    public void testProxy(){
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.div(6,2);
    }
}
