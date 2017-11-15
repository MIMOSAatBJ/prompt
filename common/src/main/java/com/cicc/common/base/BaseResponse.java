package com.cicc.common.base;

import com.cicc.common.exception.GlobalException;

/**
 * 返回到前台的数据结构
 */
public class BaseResponse {
    public BaseResponse() {
    }

    public BaseResponse(GlobalException ge) {
        this.code = ge.getCode();
        this.info = ge.getInfo();
    }

    public BaseResponse(Integer code, String info, Object data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }

    private Integer code;
    private String info;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static void main(String[] args) {
    }
}
