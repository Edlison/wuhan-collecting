package com.wuhan.collecting.model;

import lombok.Data;

@Data
public class Count {
    private long id;
    private long countRegionId;
    private String countDate;
    private long countConfirm;
    private long countRecover;
    private long countDead;
    private String countSourceText;
    private String countSourceUrl;
    private long countUserId;
    private long countCreateTime;
    private long countModifiedTime;
}

