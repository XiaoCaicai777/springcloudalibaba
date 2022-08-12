package com.common.provider.service.impl;

import com.common.provider.service.CommonService;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Date 2022-08-11 17:22
 * @Author JW
 */
@Service
public class CommonServiceImpl implements CommonService {
    @Override
    public String commonHello(String name) {
        if ("abc".equals(name)) {
            throw new RuntimeException("abc错误！！！");
        }
        return name + "   commonHello";
    }
}
