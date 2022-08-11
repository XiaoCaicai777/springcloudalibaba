package com.study.demo.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.study.demo.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Date 2022-08-11 15:30
 * @Author JW
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    @SentinelResource(value = "sayHello", blockHandler = "sayHelloBlockHandler", fallback = "fallback")
    public String sayHello(String str) {
        if ("abc".equals(str)) {
            throw new RuntimeException("手动异常！！！");
        }
        return str + "SayHello!!!";
    }

    public String sayHelloBlockHandler(String str, BlockException blockException) {
        return str + "出错啦！！！";
    }

    public String fallback(String str, Throwable runtimeException) {
        return str + "出错啦！！！" + "    " + runtimeException.getMessage();
    }
}
