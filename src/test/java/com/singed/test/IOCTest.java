package com.singed.test;

import com.singed.annotation.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author : Singed
 * @Date : 2021/9/7 20:35
 */
public class IOCTest {
    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }
    }
}
