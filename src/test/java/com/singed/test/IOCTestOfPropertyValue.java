package com.singed.test;

import com.singed.annotation.beans.Person;
import com.singed.annotation.config.MainConfigOfPorpertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author : Singed
 * @Date : 2021/9/8 23:42
 */
public class IOCTestOfPropertyValue {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPorpertyValue.class);

    @Test
    public void test01() {
        printBeans(context);
        System.out.println("=====================");
        Person person = context.getBean(Person.class);
        System.out.println(person);

        ConfigurableEnvironment environment = context.getEnvironment();
        //打印出配置文件中的值。此配置文件的值被加载到了环境变量中
        System.out.println(environment.getProperty("person.nickName"));
        context.close();
    }

    private void printBeans(ApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
