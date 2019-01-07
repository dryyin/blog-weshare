package com.gitsck.pojo;

public class GArticleCustom extends GArticle{

    private String authorName;

    private String kindText;

    public String getKindText() {
        return kindText;
    }

    public void setKindText(String kindText) {
        this.kindText = kindText;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}