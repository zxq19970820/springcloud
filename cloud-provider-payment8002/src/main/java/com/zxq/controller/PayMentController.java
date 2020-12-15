package com.zxq.controller;

import com.zxq.entites.CommonResult;
import com.zxq.entites.Payment;
import com.zxq.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author com.zxq
 * @version 1.0
 * @date 2020/11/30 22:55
 */
@RestController
@Slf4j
public class PayMentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

//    接收json数据
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        Integer result = paymentService.create(payment);
        log.info("****插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果：" + payment);
        if (payment !=null) {
            return new CommonResult(200, "查询成功,serverPort:"+serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，失败", null);
        }
    }

    @GetMapping(value = "/pay/discovery")
    public Object discovery() {

        //获取服务列表清单
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element: " + element);
        }

//CLOUD-PAYMENT-SERVICE 实例下的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
