package com.singed.annotation.config;

import com.singed.annotation.beans.Color;
import com.singed.annotation.beans.ColorFactoryBean;
import com.singed.annotation.beans.Person;
import com.singed.annotation.beans.Red;
import com.singed.annotation.condition.LinuxCondition;
import com.singed.annotation.condition.MyImportBeanDefinitionRegistrar;
import com.singed.annotation.condition.MyImportSelector;
import com.singed.annotation.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @author : Singed
 * @Date : 2021/9/7 21:24
 */
//满足当前条件类中组件统一设置，这个类配置的所有bean才会生效
//@Conditional(value = {WindowsCondition.class})
@Configuration
//@Import(Color.class)
@Import(value = {Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//@Import快速导入组件，id默认是组件的全类名
public class MainConfig2 {
    /**
     * 默认是单例的
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE  singleton
     * ConfigurableBeanFactory#SCOPE_SINGLETON  prototype
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION  session
     * <p>
     * prototype：
     * 多实例的   ioc容器启动并不会调用方法创建对象放在容器中，
     * 每次获取的时候才会调用方法创建对象；
     * <p>
     * singleton：
     * 单实例（默认值），ioc容器启动会调用方法创建对象放到ioc容器中
     * 以后每次获取都是直接从容器（map.get()）中拿取
     * <p>
     * request：同一个请求创建一个实例
     * session:同一个session创建一个实例
     * <p>
     * 懒加载：
     * 单实例Bean：默认在容器启动的时候创建对象
     * 懒加载：容器启动不创建对象。第一次使用（获取）Bean创建对象，并初始化
     */
    @Lazy
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person。。。。。");
        return new Person("zhangsan", 25);
    }

    /**
     * @Conditional : 按照一定的条件进行判断，满足条件给容器中注册Bean
     * 如果系统是windows,给容器注册bill
     * 如果系统是linux,给容器注册linus
     */
    @Conditional(value = {WindowsCondition.class})
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 62);
    }

    @Conditional(value = {LinuxCondition.class})
    @Bean("linus")
    public Person person02() {
        return new Person("linus", 48);
    }

    /**
     * 给容器中注册组件：
     * 1）包扫描 只要标注了@Controller/@Service/@Repository/@Component
     * 都会被扫描直接加入容器中 自己实现的类
     * 2）@Bean导入的第三方包里面的组件
     * 3）@Import[快速的给容器中导入组件]
     *      1] @Import(value = {Color.class, Red.class})
     *          容器中就会自动注册这个组件，id默认是全类名
     *          com.singed.annotation.beans.Color
     *          com.singed.annotation.beans.Red
     *      2] ImportSelector：返回需要导入的组件的全类名的数组
     *      3] ImportBeanDefinitionRegistrar:手动注册到bean容器中
     * 4）使用Spring提供的FactoryBean(工厂Bean)
     *      1] 默认调用的是FactoryBean的getObject创建的对象
     *      2] 要获取FactoryBean本身，我们需要再id前面加一个&标识
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
