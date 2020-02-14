/*
 * Copyright (c) 2020.
 *
 * Project Name: collecting.
 * Date: 2020/2/6 下午12:08
 *
 * Author: Edlison.
 */

package com.wuhan.collecting.DTO;

import lombok.Data;

@Data
public class GetCountDTO {
    private long id;
    private long countRegionId;
    private long countConfirm;
    private long countRecover;
    private long countDead;
    private String locName;
    private String countSourceText;
    private String countSourceUrl;
}
