package com.my.nacos_server;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true)
@EnableNacosDiscovery(globalProperties = @NacosProperties(serverAddr = "${nacos.discovery.server-addr}"))
public class NacosClientApplication {
	@NacosInjected
	private NamingService namingService;

	@Value("${spring.application.name}")
	private String applicationName;

	@PostConstruct
	private void registerServer() throws NacosException {
		namingService.registerInstance(applicationName,"47.104.246.14",8848);
	}

	public static void main(String[] args) {
		SpringApplication.run(NacosClientApplication.class, args);
	}

}
