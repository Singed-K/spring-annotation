package com.singed.annotation.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author : Singed
 * @Date : 2021/9/8 22:45
 */
@Component
public class Dog implements ApplicationContextAware {

    //实现ApplicationContextAware为组件注入ioc容器
    private ApplicationContext applicationContext;

    public Dog() {
        System.out.println("dog consturct....");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("post construct....");
    }

    //容器移除对象之前
    @PreDestroy
    public void destory(){
        System.out.println("dog pre destory....");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
