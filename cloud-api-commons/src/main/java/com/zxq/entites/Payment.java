package com.zxq.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author com.zxq
 * @version 1.0
 * @date 2020/11/30 22:05
 */

@Data       //get  set hashcode toString equals
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}
