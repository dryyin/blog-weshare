package com.gitsck.pojo;

public class GArticle {
    private Long aId;

    private String aTitle;

    private Integer aView;

    private Long kId;

    private String aCretime;

    private String aExtends;

    private String aText;

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle == null ? null : aTitle.trim();
    }

    public Integer getaView() {
        return aView;
    }

    public void setaView(Integer aView) {
        this.aView = aView;
    }

    public Long getkId() {
        return kId;
    }

    public void setkId(Long kId) {
        this.kId = kId;
    }

    public String getaCretime() {
        return aCretime;
    }

    public void setaCretime(String aCretime) {
        this.aCretime = aCretime == null ? null : aCretime.trim();
    }

    public String getaExtends() {
        return aExtends;
    }

    public void setaExtends(String aExtends) {
        this.aExtends = aExtends == null ? null : aExtends.trim();
    }

    public String getaText() {
        return aText;
    }

    public void setaText(String aText) {
        this.aText = aText == null ? null : aText.trim();
    }
}