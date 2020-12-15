package com.zxq.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author zxq
 * @version 1.0
 * @date 2020/12/13 21:50
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***********come in MyLogGateWayFilter:  " + new Date());
                                        //        获取请求参数        指定uname
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");

        //合法性检验
        if (uname == null) {
            log.info("*******用户名为null，非法用户，o(╥﹏╥)o");

            //设置 response 状态码   因为在请求之前过滤的，so就算是返回NOT_FOUND 也不会返回错误页面
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);


            //完成请求调用
            return exchange.getResponse().setComplete();
        }
//放行，进行下一个过滤链的过滤
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {

        //返回值是加载顺序，一般全局的都是第一位加载
//        数字越小，优先级越高
        return 0;
    }
}