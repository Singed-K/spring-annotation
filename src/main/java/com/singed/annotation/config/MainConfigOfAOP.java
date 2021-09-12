package com.singed.annotation.config;

import com.singed.annotation.aop.LogAspects;
import com.singed.annotation.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP:【动态代理】
 *      指在程序运行旗舰动态的将某段代码切入到指定位置进行运行的编程方式；
 *
 * 1）。导入AOP模块;Spring AOP:导入【spring-aspects】
 * 2）。定义一个业务逻辑类【MathCalculator】；在业务逻辑运行的时候打印日志（方法之前，方法之后，方法异常）
 * 3）。定义一个日志切面类【LogAspects】;切面类里面的方法需要动态感知MathCalculator.div运行到了哪里
 *      通知方法：
 *          前置通知(@Before)：logStart:在目标方法之前运行
 *          后置通知(@After)：logEnd:目标方法运行之后通知（无论方法是正常结束还是异常结束）
 *          返回通知(@AfterReturning)：logReturn:在目标方法正常返回之后运行
 *          异常同志(@AfterThrowing)：logException:在目标方法运行异常以后来运行
 *          环绕通知(@Around)：动态代理：手动推进目标方法的运行（joinPoint.procced()）
 * 4).给切面类的目标方法标注合适何地运行(通知注解)
 * 5）。将切面类和业务类（目标方法所在类）都加入到容器中
 * 6）。必须告诉Spring容器那个类是切面类（给切面类上加一个注解 @Aspect）
 * 7）。给配置类加上@EnableAspectJAutoProxy【开启基于注解的AOP模式】
 *      在Spring中有很多的@EnableXXX;
 *
 * 三部：
 *      1）。将业务逻辑主键和切面类都加入到容器中；告诉Spring哪个是切面类（@Aspect）
 *      2）。在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 *      3）。开启基于注解的AOP模式 @EnableAspectJAutoProxy
 *
 * AOP原理【看给容器中注册了什么组件，这个组件什么时候工作，这个组件工作时候的功能是什么】：
 *      @EnableAspectJAutoProxy;
 * 1.@EnableAspectJAutoProxy是什么
 *      @Import(AspectJAutoProxyRegistrar.class) 给容器中导入AspectJAutoProxyRegistrar.class
 *          利用AspectJAutoProxyRegistrar自定义给容器注册Bean;
 *              internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 *      给容器中注册一个AnnotationAwareAspectJAutoProxyCreator；
 * 2.AnnotationAwareAspectJAutoProxyCreator；
 *      AnnotationAwareAspectJAutoProxyCreator
 *          ->AspectJAwareAdvisorAutoProxyCreator
 *              ->AbstractAdvisorAutoProxyCreator
 *                  ->AbstractAutoProxyCreator
 *                      implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *                      关注后置处理器（在Bean初始化完成前后做事情），自动装配BeanFactory
 *      AbstractAutoProxyCreator.setBeanFactory
 *      AbstractAutoProxyCreator,有后置处理器的逻辑
 *          postProcessBeforeInstantiation/postProcessAfterInitialization
 *      AbstractAdvisorAutoProxyCreator.setBeanFactory【此过程进行了重写】->initBeanFactory,
 *      AspectJAwareAdvisorAutoProxyCreator【无BeanPostProcessor和BeanFactory相关的方法】
 *      AnnotationAwareAspectJAutoProxyCreator.initBeanFactory【此过程进行了重写】
 * 流程：
 *      1.传入配置类创建ioc容器
 *      2.注册配置类，调用refresh(),刷新容器；
 *      3.registerBeanPostProcessors(beanFactory);;注册Bean的后置处理器来方便拦截Bean的创建
 *          1】。先获取ioc容器中已经定义了的需要创建对象的所有BeanPostProcessor
 *          2】。给容器中加别的BeanPostProcessor
 *          3】。有限注册实现了PriorityOrdered接口的BeanPostProcessor
 *          4】。再给容器中注册实现了Ordered接口的BeanPostProcessor
 *          5】。注册没有实现优先级接口的BeanPostProcessor
 *          6】。注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，然后保存在容器中
 *              创建internalAutoProxyCreator的BeanPostProcessor【AnnotationAwareAspectJAutoProxyCreator】
 *              1.创建Bean的实例
 *              2.populateBean(beanName, mbd, instanceWrapper);给Bean的各种属性赋值
 *              3.initializeBean(beanName, exposedObject, mbd);初始化Bean
 *                  1].invokeAwareMethods(beanName, bean);处理Aware接口的方法回调
 *                  2].applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);应用后置处理器的postProcessBeforeInitialization方法
 *                  3].invokeInitMethods(beanName, wrappedBean, mbd);执行自定义的初始化方法
 *                  4].applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);应用后置处理器的postProcessAfterInitialization方法
 *              4.BeanPostProcessor（AnnotationAwareAspectJAutoProxyCreator）创建成功;--aspectJAdvisorsBuilder
 *          7】。把BeanPostProcessor注册到beanFactory中；
 *              beanFactory.addBeanPostProcessor(postProcessor);
 *
 *
 *
 * @Author : Singed
 * @Date : 2021/9/13 0:05
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {
    //业务逻辑类加入到容器中
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }

    //切面类加到容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
