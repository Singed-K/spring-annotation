package com.singed.annotation.controller;

import com.singed.annotation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author : Singed
 * @Date : 2021/9/7 20:33
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
}
