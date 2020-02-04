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
public class LocationDAO {
    private long id;
    private long level;
    private String code;
    private String name;
}
