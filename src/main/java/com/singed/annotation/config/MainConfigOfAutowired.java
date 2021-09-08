package com.singed.annotation.config;

import com.singed.annotation.beans.Car;
import com.singed.annotation.beans.Color;
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
 *      @AutowiredAnnotationBeanPostProcessor:解析自动装配功能
 * 3).@Autowared:构造器，参数，方法，属性；都是从容器中获取参数组件的值
 *      1】。标注在方法位置: @Bean+方法参数，参数从容器中获取；这些位置默认不写@Autowared
 *      2】。标在构造器上：如果组件只有一个有参构造器，这个有参构造器的Autowared可以省略，参数位置的组件还是可以从容器中获取
 *      3】。放在参数位置
 * 4).自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory,xxx）
 *      自定义组件实现xxxAware；在创建对象的时候会调用接口规定的方法注入相关组件
 *      把Spring底层的一些组件注入到自定义的Bean中；
 *      xxxAware:功能使用xxxProcessor来实现的
 *          ApplicationContextAware===>ApplicationContextAwareProcessor
 * @Author : Singed
 * @Date : 2021/9/9 0:11
 */
@Configuration
@ComponentScan({"com.singed.annotation.controller","com.singed.annotation.dao",
        "com.singed.annotation.service","com.singed.annotation.beans"})
public class MainConfigOfAutowired {
    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    /**
     * @Bean 标注的方法创建对象的时候，方法参数的值从容器中获取
     * @param car
     */
    @Bean
    public Color color(Car car){
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
