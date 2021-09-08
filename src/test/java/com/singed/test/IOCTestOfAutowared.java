package com.singed.test;

import com.singed.annotation.beans.Boss;
import com.singed.annotation.beans.Car;
import com.singed.annotation.beans.Color;
import com.singed.annotation.config.MainConfigOfAutowired;
import com.singed.annotation.dao.BookDao;
import com.singed.annotation.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author : Singed
 * @Date : 2021/9/8 23:42
 */
public class IOCTestOfAutowared {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    @Test
    public void test01() {
        BookService bookService = context.getBean(BookService.class);
        System.out.println(bookService);
        //BookDao bookDao = context.getBean(BookDao.class);
        //System.out.println(bookDao);
        Boss boss = context.getBean(Boss.class);
        System.out.println(boss);
        Car car = context.getBean(Car.class);
        System.out.println(car);
        Color color = context.getBean(Color.class);
        System.out.println(color);
        context.close();
    }

    private void printBeans(ApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
