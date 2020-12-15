package com.zxq.service.impl;


import com.zxq.entites.Payment;

import com.zxq.dao.PaymentDao;
import org.springframework.stereotype.Service;
import com.zxq.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author com.zxq
 * @version 1.0
 * @date 2020/11/30 22:52
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
