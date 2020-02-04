/*
 * Copyright (c) 2020.
 *
 * Project Name: collecting.
 * Date: 2020/2/4 下午4:03
 *
 * Author: Edlison.
 */

package com.wuhan.collecting.DTO;

import lombok.Data;

@Data
public class SampleDTO {
    private long id;
    private long sampleRegionId;
    private String sampleDate;
    private long sampleSex;
    private long sampleAge;
    private String sampleConfirmTime;
    private String sampleSourceUrl;
    private long sampleUserId;
    private long sampleCreateTime;
    private long sampleModifiedTime;
}
