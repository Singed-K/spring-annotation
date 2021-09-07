package com.singed.annotation.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * @Author : Singed
 * @Date : 2021/9/7 22:26
 */
public class LinuxCondition implements Condition {
    /**
     * @param context  判断条件所使用的的上下文(环境)
     * @param metadata 注释信息
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //判断是否是linux系统
        //1.能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3.获取当前环境信息
        Environment environment = context.getEnvironment();
        //4.获取Bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        return Objects.requireNonNull(environment.getProperty("os.name")).contains("linux");
    }
}
