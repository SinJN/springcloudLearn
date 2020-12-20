package com.my.nacos_server.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试nacos配置中心
 * @author: yinhui
 * @create: 2020-12-18 15:00
 **/
@RestController
@RequestMapping("nacosConfig")
public class NacosConfigController {
    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @GetMapping(value = "/get")
    @ResponseBody
    public boolean get() {
        return useLocalCache;
    }
}
