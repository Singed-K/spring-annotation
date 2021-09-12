package com.singed.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Author : Singed
 * @Date : 2021/9/13 0:11
 *
 * @Aspect 告诉Spring当前类是一个前面类
 */
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1.本类引用
    //2.其他的切面引用 com.singed.annotation.aop.LogAspects.pointCut
    @Pointcut("execution(public int com.singed.annotation.aop.MathCalculator.*(..))")
    public void pointCut(){
//
    }
    //@Before在目标方法之前切入，切入点表达式（指定在那个方法切入）*表示任意方法 ..表示任意参数个数
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"开始执行。。。参数列表是：{"+ Arrays.asList(args)+"}");
    }

    @After("com.singed.annotation.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"结束。。。");
    }

    //JoinPoint joinPoint作为参数时，必须写为第一个
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"正常返回。。。运行结果是：{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(joinPoint.getSignature().getName()+"异常。。。。异常信息为：{"+exception+"}");
    }
}
