package com.maiya.shopcloud.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ShopcloudAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopcloudAccountApplication.class, args);
    }
}
