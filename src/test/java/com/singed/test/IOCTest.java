package com.singed.test;

import com.singed.annotation.beans.Person;
import com.singed.annotation.config.MainConfig;
import com.singed.annotation.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author : Singed
 * @Date : 2021/9/7 20:35
 */
public class IOCTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testImport(){
        printBeans(context);
    }

    private void printBeans(ApplicationContext context){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test01() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }
    }

    @Test
    public void test02() {
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        for (String definitionName : beanDefinitionNames) {
//            System.out.println(definitionName);
//        }
        System.out.println("ioc容器创建完成。。。");
        Object person = context.getBean("person");
        Object person2 = context.getBean("person");
        System.out.println(person == person2);
    }

    @Test
    public void test03() {
        String[] namesForType = context.getBeanNamesForType(Person.class);
        Environment environment = context.getEnvironment();
        //获取环境变量的值：Windows 10
        String osName = environment.getProperty("os.name");
        System.out.println(osName);
        for (String name : namesForType) {
            System.out.println(name);
        }
        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }
}
