package com.singed.test;

import com.singed.annotation.aop.MathCalculator;
import com.singed.annotation.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author : Singed
 * @Date : 2021/9/13 0:35
 */
public class IOCTestOfAOP {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        MathCalculator calculator = context.getBean(MathCalculator.class);
        int div = calculator.div(1, 0);

        context.close();
    }
}
