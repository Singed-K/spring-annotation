package com.singed.annotation.config;

import com.singed.annotation.beans.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @author : Singed
 * @Date : 2021/9/7 21:24
 */
@Configuration
public class MainConfig2 {
    /**
     * 默认是单例的
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE  singleton
     * ConfigurableBeanFactory#SCOPE_SINGLETON  prototype
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION  session
     * <p>
     * prototype：
     * 多实例的   ioc容器启动并不会调用方法创建对象放在容器中，
     * 每次获取的时候才会调用方法创建对象；
     * <p>
     * singleton：
     * 单实例（默认值），ioc容器启动会调用方法创建对象放到ioc容器中
     * 以后每次获取都是直接从容器（map.get()）中拿取
     * <p>
     * request：同一个请求创建一个实例
     * session:同一个session创建一个实例
     *
     * 懒加载：
     *      单实例Bean：默认在容器启动的时候创建对象
     *      懒加载：容器启动不创建对象。第一次使用（获取）Bean创建对象，并初始化
     */
    @Lazy
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person。。。。。");
        return new Person("zhangsan", 25);
    }
}
