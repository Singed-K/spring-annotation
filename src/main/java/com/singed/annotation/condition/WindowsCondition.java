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
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1.能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3.获取当前环境信息
        Environment environment = context.getEnvironment();
        //4.获取Bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        boolean definition = registry.containsBeanDefinition("person");
        System.out.println("context中是否包含person bean:" + definition);
        return Objects.requireNonNull(environment.getProperty("os.name")).contains("Windows");
    }
}
