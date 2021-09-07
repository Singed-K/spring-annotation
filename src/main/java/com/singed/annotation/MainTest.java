package com.singed.annotation;

import com.singed.annotation.beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author : Singed
 * @Date : 2021/9/7 19:59
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("person",Person.class);
        System.out.println(person.getAge());
        System.out.println(person.getName());
    }
}
