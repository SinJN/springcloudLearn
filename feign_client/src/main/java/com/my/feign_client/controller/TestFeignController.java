package com.my.feign_client.controller;

import com.my.feign_client.feign_interface.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: springCloudTest
 * @description:
 * @author: yinhui
 * @create: 2020-12-17 14:07
 **/
@RestController
public class TestFeignController {
    @Autowired
    TestInterface testInterface;

    /**
     * 通过feign调用nacos_client里的接口
     */
    @GetMapping("testFeign")
    public String testFeign() {
        return testInterface.get();
    }
}
