package com.singed.annotation.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author : Singed
 * @Date : 2021/9/9 1:07
 */
//默认加载ioc容器中的组件，容器启动会调用无参构造器创建对象，在进行初始化赋值操作
@Component
public class Boss {
    private Car car;

    //构造器要用的组件也是在容器中
    public Boss(@Autowired Car car) {
        this.car = car;
        System.out.println("boss 的有参构造器");
    }

    public Car getCar() {
        return car;
    }


    //标注在方法上，Spring容器创建当前对象，就会调用方法，完成赋值
    //方法使用的参数，自定义类型的值从ioc容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
