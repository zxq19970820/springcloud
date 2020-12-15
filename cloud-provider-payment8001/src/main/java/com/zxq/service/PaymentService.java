package com.zxq.service;

import com.zxq.entites.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author com.zxq
 * @version 1.0
 * @date 2020/11/30 22:51
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
