package com.singed.test;

import com.singed.annotation.config.MainConfig;
import com.singed.annotation.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Singed
 * @Date : 2021/9/7 20:35
 *
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

    @Test
    public void test02(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        for (String definitionName : beanDefinitionNames) {
//            System.out.println(definitionName);
//        }
        System.out.println("ioc容器创建完成。。。");
        Object person = context.getBean("person");
        Object person2 = context.getBean("person");
        System.out.println(person == person2);
    }
}
