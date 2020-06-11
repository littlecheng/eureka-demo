package com.example.eurekaclient;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan(basePackages = "com.example.eurekaclient.mapper")
//配置mapper扫描的路径（Mybatis的mapper接口）
public class EurekaClientApplication {

    public static void main(String[] args) {
       SpringApplication.run(EurekaClientApplication.class, args);

    }

}
