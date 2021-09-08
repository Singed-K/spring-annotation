package com.singed.annotation.beans;

import org.springframework.stereotype.Component;

/**
 * @Author : Singed
 * @Date : 2021/9/8 0:03
 */
@Component
public class Car {
    public Car(){
        System.out.println("car consturctor ....");
    }

    public void init(){
        System.out.println(" car init ............");
    }

    public void destory(){
        System.out.println("car.... destory");
    }
}
