package com.singed.annotation.config;

import com.singed.annotation.beans.Car;
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
 * BeanPostProcessor.postProcessBeforeInitialization
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法。。。
 * BeanPostProcessor.postProcessAfterInitialization
 * 销毁：
 *      单实例:容器关闭的时候
 *      多实例：容器不会管理这个Bean;容器不会调用销毁方法；
 *
 * 遍历得到容器中所有的BeanPostProcessor：挨个执行BeforeInitialization。
 * 一旦返回null，跳出for循环，不会执行后面的BeanPostProcessor
 *
 * BeanPostProcessor原理
 *  populateBean(beanName, mbd, instanceWrapper);给Bean进行属性赋值
 *  initializeBean{
 *      applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *      invokeInitMethods(beanName, wrappedBean, mbd);执行初始化
 *      applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *  }
 *
 *
 *
 *
 * 1）。指定初始化和销毁方法
 *      @Bean 注解指定init-method="" destroy-method=""
 * 2）.通过让Bean实现InitializingBean（定义初始化逻辑）
 *                  DisposableBean(定义销毁逻辑)
 * 3）.可以使用JSR250:
 *      @PostConsturct: 在Bean创建完成并且属性值创建完成；来执行初始化方法
 *      @PreDestory:    在容器销毁bean之前来通知我们进行清理工作
 * 4).BeanPostProcessor【interface】,Bean的后置处理器
 *      在bean初始化前后做一些工作
 *          postProcessBeforeInitialization:在初始化工作之前
 *          postProcessAfterInitialization:在初始化之后工作
 *
 * Spring底层对BeanPostProcessor的使用
 *      Bean赋值，注入其他组件，@Autowired,生命周期注解功能，@Async,xxxBeanPostPorcessor
 */
@Configuration
@ComponentScan("com.singed.annotation.beans")
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }
}
