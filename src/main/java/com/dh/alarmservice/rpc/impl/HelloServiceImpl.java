package com.dh.alarmservice.rpc.impl;

import com.dh.alarmservice.rpc.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String name) {
        return "Hi,"+name;
    }
}
