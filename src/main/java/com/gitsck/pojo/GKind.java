package com.gitsck.pojo;

public class GKind {
    private Long kId;

    private Long kParent;

    private Integer kIsparent;

    private String kText;

    public Long getkId() {
        return kId;
    }

    public void setkId(Long kId) {
        this.kId = kId;
    }

    public Long getkParent() {
        return kParent;
    }

    public void setkParent(Long kParent) {
        this.kParent = kParent;
    }

    public Integer getkIsparent() {
        return kIsparent;
    }

    public void setkIsparent(Integer kIsparent) {
        this.kIsparent = kIsparent;
    }

    public String getkText() {
        return kText;
    }

    public void setkText(String kText) {
        this.kText = kText == null ? null : kText.trim();
    }
}