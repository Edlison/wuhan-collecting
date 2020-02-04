package com.wuhan.collecting.result;

public class   SystemResult {
    /**
     * 100 login
     * 200 register
     * 300 count
     * 400 case
     */
    private Integer status;
    private String desc;
    private String data;

    public SystemResult(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public SystemResult(Integer status, String desc, String data) {
        this.status = status;
        this.desc = desc;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
