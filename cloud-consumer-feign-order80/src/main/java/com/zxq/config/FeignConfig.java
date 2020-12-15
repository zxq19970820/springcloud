package com.zxq.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zxq
 * @version 1.0
 * @date 2020/12/8 19:19
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
//        请求和响应的头信息，请求和响应的正文及元数据
        return Logger.Level.FULL;
    }
}
