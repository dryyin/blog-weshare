package com.gitsck.service;

import com.github.pagehelper.Page;
import com.gitsck.entity.PageResult;
import com.gitsck.entity.Result;
import com.gitsck.pojo.GArticle;
import com.gitsck.pojo.GArticleCustom;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ArticleService {

    Result addArticle(GArticle gArticle, HttpSession session);

    PageResult initList(int page,int rows,GArticle gArticle);

    Result findDesc(long aId);

    Result findHot();

    Page<GArticleCustom> findALl(int page, int rows);

    Result del(long id);
}
