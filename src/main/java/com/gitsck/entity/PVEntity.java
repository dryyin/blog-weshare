package com.gitsck.entity;


import java.util.List;

public class PVEntity {

    private String startDate;

    private List<Integer> gPvs;

    private int year;

    private int month;

    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<Integer> getgPvs() {
        return gPvs;
    }

    public void setgPvs(List<Integer> gPvs) {
        this.gPvs = gPvs;
    }
}
