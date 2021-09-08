package com.singed.annotation.config;

import com.singed.annotation.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配
 *      Spring例如依赖注入（DI）,完成对IOC容器中各个组件依赖关系的赋值
 *
 * 1）。@Autowared：自动注入：
 *      1】。默认优先按照类型去容器中找对应的组件：
 *          context.getBean(BookDao.class);找到就赋值
 *      2】。如果找到了多个相同类型的组件，再将属性名作为组件的id去容器中查找
 *          context.getBean("bookDao")
 *      3】。@Qualifier("bookDao"),使用@Qualifier执行需要装配在组件的id,而不是使用属性名
 *      4】。自动装配默认一定要将属性赋值好，没有就会报错；
 *          可以使用@Autowired(required = false);
 *      5】。@Primary 让Spring进行自动装配的时候，默认使用首选的Bean
 *          也可以继续使用@Qualifier执行需要装配的Bean名字
 *
 *      BookService{
 *          @Autowared
 *          BookDao bookDao
 *      }
 * 2).Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[Java规范的注解]
 *      @Resource:
 *          可以和@Autowired一样都实现了自动装配功能：默认是按照组件名称进行装配的
 *          可以指定@Resource(name = "bookDao2")
 *          没有能支持@Primary功能没有支持@Autowired(required = false)
 *      @Inject:
 *          需要导入javax.inject包，和Autowared功能一样、没有required = false的功能
 *      @Autowared： Spring定义的；@Resource和@Inject都是java规范
 *
 *
 * @Author : Singed
 * @Date : 2021/9/9 0:11
 */
@Configuration
@ComponentScan({"com.singed.annotation.controller","com.singed.annotation.dao","com.singed.annotation.service"})
public class MainConfigOfAutowired {
    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
}
