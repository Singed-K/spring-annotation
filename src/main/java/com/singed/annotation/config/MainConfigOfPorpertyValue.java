package com.singed.annotation.config;

import com.singed.annotation.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author : Singed
 * @Date : 2021/9/8 23:40
 */
//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;
//加载完配置外部配置文件之后使用${}取出配置文件的值
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPorpertyValue {

    @Bean
    public Person person() {
        return new Person();
    }
}
