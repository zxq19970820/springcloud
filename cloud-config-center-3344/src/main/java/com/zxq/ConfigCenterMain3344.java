package com.zxq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author zxq
 * @version 1.0
 * @date 2020/12/14 20:33
 */
@SpringBootApplication
@EnableConfigServer     //关键注解，开启配置服务端
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}