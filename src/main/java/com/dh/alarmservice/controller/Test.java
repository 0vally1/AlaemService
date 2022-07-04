package com.dh.alarmservice.controller;


import com.dh.alarmservice.service.PaymentPlugin;
import com.dh.alarmservice.service.PluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller("testController")
@RestController
@RequestMapping("testController")
public class Test {

    @Resource(name="weixinPublicPaymentPlugin")
    private PaymentPlugin paymentPlugin;

    @Autowired
//    @Inject
    private List<PaymentPlugin> paymentPlugins = new ArrayList<>();

    @Autowired
    private Map<String, PaymentPlugin> paymentPluginMap = new HashMap<>();

    @Autowired
    private List<PluginService> pluginServices = new ArrayList<>();

    @Autowired
    private Map<String, PluginService> pluginServiceMap = new HashMap<>();

    @RequestMapping("/test")
    @ResponseBody
    public void test() {
        System.out.println("注入单实例:"+paymentPlugin);
        System.out.println("抽象集合list:"+paymentPlugins);
        System.out.println("抽象集合map:"+paymentPluginMap);
        System.out.println("接口集合list:"+pluginServices);
        System.out.println("接口集合map:"+pluginServiceMap);
    }


}
