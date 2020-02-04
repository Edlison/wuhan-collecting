/*
 * Copyright (c) 2020.
 *
 * Project Name: collecting.
 * Date: 2020/2/4 下午4:49
 *
 * Author: Edlison.
 */

package com.wuhan.collecting.model;

import lombok.Data;

@Data
public class PatientDAO {
    private long id;
    private long sampleSex;
    private long sampleAge;
    private long sampleConfirmTime;
    private String sampleSourceUrl;
}
