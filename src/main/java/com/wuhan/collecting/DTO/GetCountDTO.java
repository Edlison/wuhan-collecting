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
    private long countConfirm;
    private long countRecover;
    private long countDead;
    private String locName1;
    private String locName2;
    private String locName3;
    private String locName4;

    public void setLocName(int i, String locName) {
        if (i == 0) {
            setLocName1(locName);
        } else if (i == 1) {
            setLocName2(locName);
        } else if (i == 2) {
            setLocName3(locName);
        } else if (i == 3){
            setLocName4(locName);
        } else {
            System.out.println("SetNameError");
        }
    }
}
