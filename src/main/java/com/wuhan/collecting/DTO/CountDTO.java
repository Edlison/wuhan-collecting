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
public class CountDTO {
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
