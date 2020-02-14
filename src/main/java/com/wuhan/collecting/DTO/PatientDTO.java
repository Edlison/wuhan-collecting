package com.wuhan.collecting.DTO;

import lombok.Data;

@Data
public class PatientDTO {
    private long id;
    private long sampleRegionId;
    private long sampleSex;
    private long sampleAge;
    private String sampleConfirmTime;
    private String sampleSourceText;
    private String sampleSourceUrl;
    private String locName;
}
