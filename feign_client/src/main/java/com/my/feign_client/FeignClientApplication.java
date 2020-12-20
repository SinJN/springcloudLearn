package com.my.feign_client;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;

@SpringBootApplication
//配置中心
@NacosPropertySource(dataId = "example", autoRefreshed = true)
//注册到注册中心
@EnableNacosDiscovery(globalProperties = @NacosProperties(serverAddr = "${nacos.discovery.server-addr}"))
//启用feign客户端
@EnableFeignClients
public class FeignClientApplication {
	@NacosInjected
	private NamingService namingService;

	@Value("${spring.application.name}")
	private String applicationName;

	@PostConstruct
	private void registerServer() throws NacosException {
		namingService.registerInstance(applicationName,"47.104.246.14",8848);
	}
	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}

}
