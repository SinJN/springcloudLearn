package com.my.nacos_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springCloudTest
 * @description:
 * @author: yinhui
 * @create: 2020-12-17 11:50
 **/
@RestController
public class TestController {
    @GetMapping("/get")
    public String get() {
        return "试试就试试";
    }
}