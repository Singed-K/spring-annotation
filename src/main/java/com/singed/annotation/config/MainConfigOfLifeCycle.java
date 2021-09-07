package com.singed.annotation.config;

import com.singed.annotation.beans.Car;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : Singed
 * @Date : 2021/9/7 23:59
 * Bean的生命周期：
 *      bean创建----》初始化----》销毁的过程
 * 容器管理bean的生命周期
 * 我们可以自定义初始化和销毁方法：容器在Bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *
 * 构造（对象创建）
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建对象
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法。。。
 * 销毁：
 *      单实例:容器关闭的时候
 *      多实例：容器不会管理这个Bean;容器不会调用销毁方法；
 * 1）。指定初始化和销毁方法
 *      @Bean 注解指定init-method="" destroy-method=""
 * 2）.通过让Bean实现InitializingBean（定义初始化逻辑）
 *                  DisposableBean(定义销毁逻辑)
 */
@Configuration
@ComponentScan("com.singed.annotation.beans")
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }

}
