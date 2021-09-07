package com.singed.annotation.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author : Singed
 * @Date : 2021/9/8 0:20
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat(){
        System.out.println("cat constructor ....");
    }

    @Override
    public void destroy() throws Exception {
        //销毁方法
        System.out.println("cat destory ....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //初始化方法
        System.out.println("cat afterPropertiesSet  ...............");
    }
}
