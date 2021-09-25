package com.singed.annotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author : Singed
 * @Date : 2021/9/16 21:28
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void insertUser() {
        userDao.insert();
        System.out.println("插入完成。。。");
        //int i=5/0;
    }
}
