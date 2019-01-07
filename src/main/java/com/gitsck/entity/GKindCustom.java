package com.gitsck.entity;

import com.gitsck.pojo.GKind;

import java.util.List;

public class GKindCustom extends GKind {
    private List<GKind> childList;

    public List<GKind> getChildList() {
        return childList;
    }

    public void setChildList(List<GKind> childList) {
        this.childList = childList;
    }
}
