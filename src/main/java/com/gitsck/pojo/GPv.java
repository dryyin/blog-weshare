package com.gitsck.pojo;

public class GPv {
    private Long pvId;

    private String pvDate;

    private Integer pv;

    public Long getPvId() {
        return pvId;
    }

    public void setPvId(Long pvId) {
        this.pvId = pvId;
    }

    public String getPvDate() {
        return pvDate;
    }

    public void setPvDate(String pvDate) {
        this.pvDate = pvDate == null ? null : pvDate.trim();
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }
}