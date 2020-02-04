package com.wuhan.collecting.DTO;

public class PatientDTO {
    private long id;
    private long caseSex;
    private long caseAge;
    private String caseConfirmTime;
    private String caseSourceUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCaseSex() {
        return caseSex;
    }

    public void setCaseSex(long caseSex) {
        this.caseSex = caseSex;
    }

    public long getCaseAge() {
        return caseAge;
    }

    public void setCaseAge(long caseAge) {
        this.caseAge = caseAge;
    }

    public String getCaseConfirmTime() {
        return caseConfirmTime;
    }

    public void setCaseConfirmTime(String caseConfirmTime) {
        this.caseConfirmTime = caseConfirmTime;
    }

    public String getCaseSourceUrl() {
        return caseSourceUrl;
    }

    public void setCaseSourceUrl(String caseSourceUrl) {
        this.caseSourceUrl = caseSourceUrl;
    }
}
