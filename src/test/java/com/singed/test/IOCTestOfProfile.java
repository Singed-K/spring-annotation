package com.singed.test;

import com.singed.annotation.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @Author : Singed
 * @Date : 2021/9/8 23:42
 */
public class IOCTestOfProfile {


    //1.使用命令行动态参数的形式 在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2.使用代码的方式,在context refresh之前设置env中的profile参数
    //3.在类上使用@Profile
    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //1.创建一个ApplicationContext
        //2.设置需要激活的环境
        context.getEnvironment().setActiveProfiles("test");
        //3.注册主配置类
        context.register(MainConfigOfProfile.class);
        //4.启动刷新容器
        context.refresh();
        String[] beanNamesForType = context.getBeanNamesForType(DataSource.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
        printBeans(context);
        context.close();
    }

    private void printBeans(ApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
