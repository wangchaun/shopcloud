package com.maiya.shopcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Noaman
 * @create 2018-09-13 下午7:40
 * 服务注册与发现
 **/
@EnableEurekaServer
@SpringBootApplication
public class ShopCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopCloudEurekaApplication.class, args);
    }
}