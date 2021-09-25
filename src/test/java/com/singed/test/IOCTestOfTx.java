package com.singed.test;

import com.singed.annotation.tx.TxConfig;
import com.singed.annotation.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author : Singed
 * @Date : 2021/9/13 0:35
 */

public class IOCTestOfTx {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.insertUser();
        context.close();
    }
}
