package com.singed.annotation.config;

import com.singed.annotation.beans.Person;
import com.singed.annotation.dao.BookDao;
import com.singed.annotation.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author : Singed
 * @Date : 2021/9/7 20:16
 * 配置类==配置文件
 */
@Configuration      //告诉Spring这是一个配置类
@ComponentScans(value = {
        /*@ComponentScan(value = "com.singed", includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
        }, useDefaultFilters = false),*/
        @ComponentScan(value = "com.singed", includeFilters = {
                /*@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookDao.class}),*/
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFliter.class})
        }, useDefaultFilters = false)
})
//@ComponentScan value:指定要扫描的包
//excludeFilters = Filter[],指定扫描的时候按照某些规则排除哪些组件
//includeFilters = Filter[],指定扫描的时候只需要包含哪些组件;需要禁用默认Filter useDefaultFilters = false
//FilterType.ANNOTATION,按照注解来扫描
//FilterType.ASSIGNABLE_TYPE,按照给定的类型
//FilterType.ASPECTJ,使用ASPECTJ表达式
//FilterType.REGEX,使用正则表达式
//FilterType.CUSTOM,使用自定义规则
public class MainConfig {
    //给容器中注册一个Bean;类型为返回值的类型，id默认是方法名作为id
    //括号中的值直接指定了Bean的id,此时不在使用方法名作为id
    @Bean("persion")
    public Person person01() {
        return new Person("lisi", 20);
    }
}
