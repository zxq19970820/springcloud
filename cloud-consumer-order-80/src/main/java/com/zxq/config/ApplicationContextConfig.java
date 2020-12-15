package com.zxq.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author com.zxq
 * @version 1.0
 * @date 2020/12/1 19:51
 */
@Configuration
public class ApplicationContextConfig {


    @Bean
    @LoadBalanced  //开启restTemplate负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
