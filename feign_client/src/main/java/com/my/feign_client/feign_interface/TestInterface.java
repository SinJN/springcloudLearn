package com.my.feign_client.feign_interface;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * feign接口类
 * @program: springCloudTest
 * @description:
 * @author: yinhui
 * @create: 2020-12-17 14:11
 **/
@FeignClient(name="nacos-client")
public interface TestInterface {

    @GetMapping(value = "/get")
    @LoadBalanced
    String get();
}
