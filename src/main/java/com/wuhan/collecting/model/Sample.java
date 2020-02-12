package com.wuhan.collecting.model;

import lombok.Data;

@Data
public class Sample {
    private long id;
    private long sampleRegionId;
    private long sampleDate;
    private long sampleSex;
    private long sampleAge;
    private String sampleConfirmTime;
    private String sampleSourceText;
    private String sampleSourceUrl;
    private long sampleUserId;
    private long sampleCreateTime;
    private long sampleModifiedTime;
}
