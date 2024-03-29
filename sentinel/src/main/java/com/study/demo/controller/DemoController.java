package com.study.demo.controller;

import com.study.demo.feign.CommonFeign;
import com.study.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2022-08-11 15:30
 * @Author JW
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;
    @Autowired
    private CommonFeign commonFeign;

    @GetMapping("/sayHello")
    public String sayHello(String str){
        return demoService.sayHello(str);
    }

    @GetMapping("/commonHello")
    public String commonHello(String name){
        return commonFeign.commonHello(name);
    }
}
