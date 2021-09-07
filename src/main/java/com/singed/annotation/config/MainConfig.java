package com.singed.annotation.config;

import com.singed.annotation.beans.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : Singed
 * @Date : 2021/9/7 20:16
 * 配置类==配置文件
 */
@Configuration      //告诉Spring这是一个配置类
public class MainConfig {
    //给容器中注册一个Bean;类型为返回值的类型，id默认是方法名作为id
    //括号中的值直接指定了Bean的id,此时不在使用方法名作为id
    @Bean("persion")
    public Person person01() {
        return new Person("lisi", 20);
    }
}
