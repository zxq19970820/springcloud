package com.zxq.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author com.zxq
 * @version 1.0
 * @date 2020/11/30 22:09
 */

@Data       //get  set hashcode toString equals
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> { 
    private Integer code;
    private String message;
    private T data;



    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
