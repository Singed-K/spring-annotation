package com.singed.annotation;

import com.singed.annotation.beans.Person;
import com.singed.annotation.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author : Singed
 * @Date : 2021/9/7 19:59
 */
public class MainTest {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = context.getBean("person",Person.class);
//        System.out.println(person.getAge());
//        System.out.println(person.getName());
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//        Person person = context.getBean("person", Person.class);
        Person person = context.getBean(Person.class);
        System.out.println(person);
        //找到class对应的id
        String[] nameForType = context.getBeanNamesForType(Person.class);
        for (String s : nameForType) {
            System.out.println(s);
        }


    }
}
