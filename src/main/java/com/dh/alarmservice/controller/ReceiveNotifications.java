package com.dh.alarmservice.controller;

import com.alibaba.excel.EasyExcel;
import com.dh.alarmservice.common.ResponseData;
import com.dh.alarmservice.common.ZabbixInfo;
import com.dh.alarmservice.model.StudentInfo;
import com.dh.alarmservice.model.StudentInfoExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("call")
public class ReceiveNotifications {

    @Autowired
    public HttpServletResponse response;

    @Autowired
    public HttpServletRequest request;

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

    @RequestMapping("export")
    public Object export() throws Exception {

        List<StudentInfoExcel> list = new ArrayList<>();

        StudentInfoExcel studentInfoExcel = new StudentInfoExcel();
//        list.add(studentInfoExcel);

        StudentInfo studentInfo = new StudentInfo();
        studentInfo = new StudentInfo();
        studentInfo.setId("7");
        studentInfo.setName("李");
        studentInfo.setAdmissionTicketNumber("02138170107");
        studentInfo.setInfo(studentInfo.getId()+"."+studentInfo.getName()+"\n"+studentInfo.getAdmissionTicketNumber());
        studentInfoExcel.setA(studentInfo.getInfo());

        list.add(studentInfoExcel);

        String fileName = "学生".concat("_").concat(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())).concat(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
        response.flushBuffer();
        EasyExcel.write(response.getOutputStream(), StudentInfoExcel.class).sheet("学生").doWrite(list);
        return new ResponseData<>();
    }


}
