package com.common.provider.controller;

import com.common.provider.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Date 2022-08-12 14:16
 * @Author JW
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @GetMapping("/hello")
    public String commonHello(String name){
        return commonService.commonHello(name);
    }

    @GetMapping("/testArray")
    public String testArray(String [] names){
        return names.toString() ;
    }
}
