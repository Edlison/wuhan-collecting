package com.wuhan.collecting.model;

public class Case {
    private long id;
    private long caseRegionId;
    private String caseDate;
    private long caseSex;
    private long caseAge;
    private String caseConfirmTime;
    private String caseSourceUrl;
    private long caseUserId;
    private long caseCreateTime;
    private long caseModifiedTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCaseRegionId() {
        return caseRegionId;
    }

    public void setCaseRegionId(long caseRegionId) {
        this.caseRegionId = caseRegionId;
    }

    public String getCaseDate() {
        return caseDate;
    }

    public void setCaseDate(String caseDate) {
        this.caseDate = caseDate;
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

    public long getCaseUserId() {
        return caseUserId;
    }

    public void setCaseUserId(long caseUserId) {
        this.caseUserId = caseUserId;
    }

    public long getCaseCreateTime() {
        return caseCreateTime;
    }

    public void setCaseCreateTime(long caseCreateTime) {
        this.caseCreateTime = caseCreateTime;
    }

    public long getCaseModifiedTime() {
        return caseModifiedTime;
    }

    public void setCaseModifiedTime(long caseModifiedTime) {
        this.caseModifiedTime = caseModifiedTime;
    }
}
