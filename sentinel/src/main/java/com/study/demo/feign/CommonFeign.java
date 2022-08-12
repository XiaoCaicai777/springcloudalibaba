package com.study.demo.feign;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description TODO
 * @Date 2022-08-12 14:28
 * @Author JW
 */
@FeignClient(value = "common-service", path = "/common", fallback = CommonFeign.FallBackClass.class, configuration = CommonFeign.FallBackConfiguration.class)
public interface CommonFeign {

    @GetMapping("/hello")
    String commonHello(@RequestParam(value = "name") String name);

    class FallBackClass implements  CommonFeign{
        @Override
        public String commonHello(String name) {
            return "调用common失败！！！";
        }
    }


    class FallBackConfiguration {
        @Bean
        public FallBackClass fallBackClass() {
            return new FallBackClass();
        }
    }
}
