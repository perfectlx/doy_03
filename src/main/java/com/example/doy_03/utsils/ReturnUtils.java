package com.example.doy_03.utsils;

import java.util.List;

/**
 * @Author 开挖机的人
 * @Date 2023/5/27 11:47
 */
public class ReturnUtils {
    private  Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    private  String message;
    private List list;
}
