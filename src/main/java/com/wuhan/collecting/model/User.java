package com.wuhan.collecting.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String phone;
    private String password;
    private long regionId;
    private long status;
    private long createTime;
    private long modifiedTime;
    private String token;
}
