package com.dh.alarmservice.common;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class ZabbixInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "电话为必填项")
    @Length(min = 10,max = 15,message = "电话长度必须位于10到15之间")
    private String phone;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}


