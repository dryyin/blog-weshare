package com.gitsck.entity;

public class BaseDataEntity {

    private int totalPV;

    private int totalKinds;

    private int totalUser;

    private int totalArticles;

    public BaseDataEntity(int totalPV, int totalKinds, int totalUser, int totalArticles) {
        this.totalPV = totalPV;
        this.totalKinds = totalKinds;
        this.totalUser = totalUser;
        this.totalArticles = totalArticles;
    }

    public int getTotalPV() {
        return totalPV;
    }

    public void setTotalPV(int totalPV) {
        this.totalPV = totalPV;
    }

    public int getTotalKinds() {
        return totalKinds;
    }

    public void setTotalKinds(int totalKinds) {
        this.totalKinds = totalKinds;
    }

    public int getTotalUser() {
        return totalUser;
    }

    public void setTotalUser(int totalUser) {
        this.totalUser = totalUser;
    }

    public int getTotalArticles() {
        return totalArticles;
    }

    public void setTotalArticles(int totalArticles) {
        this.totalArticles = totalArticles;
    }
}
