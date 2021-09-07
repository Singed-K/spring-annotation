package com.singed.annotation.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author : Singed
 * @Date : 2021/9/7 23:46
 */
//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * 返回一个Color对象，这个对象会添加到容器中
     */
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * true是单例，在容器中只会保存一份
     * false多实例，每次获取都会创建一个新的Bean
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
