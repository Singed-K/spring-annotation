package com.singed.annotation.config;

import com.singed.annotation.beans.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Author : Singed
 * @Date : 2021/9/7 20:16
 * 配置类==配置文件
 */
@Configuration      //告诉Spring这是一个配置类

@ComponentScans(value = {
        @ComponentScan(value = "com.singed", includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
        }, useDefaultFilters = false),
        @ComponentScan(value = "com.singed", includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class})
        }, useDefaultFilters = false)
})
//@ComponentScan value:指定要扫描的包
//excludeFilters = Filter[],指定扫描的时候按照某些规则排除哪些组件
//includeFilters = Filter[],指定扫描的时候只需要包含哪些组件;需要禁用默认Filter useDefaultFilters = false
public class MainConfig {
    //给容器中注册一个Bean;类型为返回值的类型，id默认是方法名作为id
    //括号中的值直接指定了Bean的id,此时不在使用方法名作为id
    @Bean("persion")
    public Person person01() {
        return new Person("lisi", 20);
    }
}
