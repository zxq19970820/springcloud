package com.zxq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author com.zxq
 * @version 1.0
 * @date 2020/12/6 20:13
 */
@RestController
@Slf4j
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/pay/zk", String.class);
        return result;
    }

}
