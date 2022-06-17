package com.dh.alarmservice.controller;

import com.dh.alarmservice.common.ResponseData;
import com.dh.alarmservice.common.ZabbixInfo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("call")
public class ReceiveNotifications {

    private Map<String,String> mapIphone = new ConcurrentHashMap<>();

    @PostMapping("phone")
    public Object call_phone(@RequestBody ZabbixInfo zabbixInfo)  throws Exception{
        mapIphone.put("phone",zabbixInfo.getPhone());
        WebSocketServer.sendInfo(new ResponseData<Object>("200","SUCCESS",zabbixInfo.getPhone()).toString());
        return new ResponseData<Object>("200","SUCCESS","already calling");
    }

    @PostMapping("signal")
    public Object call_signal(@RequestBody Map map)  throws Exception{
        String phone = mapIphone.get("phone");
        mapIphone.put("phone","");
        if(StringUtils.isEmpty(phone)){
            return new ResponseData<Object>("201","NULL","");
        }
        return new ResponseData<Object>("200","SUCCESS",phone);
    }



}
