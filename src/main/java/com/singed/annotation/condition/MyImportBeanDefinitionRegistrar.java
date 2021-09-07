package com.singed.annotation.condition;

import com.singed.annotation.beans.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author : Singed
 * @Date : 2021/9/7 23:31
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param importingClassMetadata 当前类的注解信息
     * @param registry               bean定义的注册类
     *                               把所有需要添加到容器中的Bean:BeanDefinitionRegistry.registerBeanDefinition()
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.singed.annotation.beans.Red");
        boolean blue = registry.containsBeanDefinition("com.singed.annotation.beans.Blue");
        if (red && blue) {
            //Bean的定义信息：（Bean的类型，Bean Scope的作用域）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }
    }
}
