package com.wuhan.collecting.model;

public class Count {
    private long id;
    private long countRegionId;
    private String countDate;
    private long countConfirm;
    private long countRecover;
    private long countDead;
    private String countSourceUrl;
    private long countUserId;
    private long countCreateTime;
    private long countModifiedTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCountRegionId() {
        return countRegionId;
    }

    public void setCountRegionId(long countRegionId) {
        this.countRegionId = countRegionId;
    }

    public String getCountDate() {
        return countDate;
    }

    public void setCountDate(String countDate) {
        this.countDate = countDate;
    }

    public long getCountConfirm() {
        return countConfirm;
    }

    public void setCountConfirm(long countConfirm) {
        this.countConfirm = countConfirm;
    }

    public long getCountRecover() {
        return countRecover;
    }

    public void setCountRecover(long countRecover) {
        this.countRecover = countRecover;
    }

    public long getCountDead() {
        return countDead;
    }

    public void setCountDead(long countDead) {
        this.countDead = countDead;
    }

    public String getCountSourceUrl() {
        return countSourceUrl;
    }

    public void setCountSourceUrl(String countSourceUrl) {
        this.countSourceUrl = countSourceUrl;
    }

    public long getCountUserId() {
        return countUserId;
    }

    public void setCountUserId(long countUserId) {
        this.countUserId = countUserId;
    }

    public long getCountCreateTime() {
        return countCreateTime;
    }

    public void setCountCreateTime(long countCreateTime) {
        this.countCreateTime = countCreateTime;
    }

    public long getCountModifiedTime() {
        return countModifiedTime;
    }

    public void setCountModifiedTime(long countModifiedTime) {
        this.countModifiedTime = countModifiedTime;
    }
}

