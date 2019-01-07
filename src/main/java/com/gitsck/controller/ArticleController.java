package com.gitsck.controller;

import com.github.pagehelper.Page;
import com.gitsck.entity.PageResult;
import com.gitsck.entity.Result;
import com.gitsck.pojo.GArticle;
import com.gitsck.pojo.GArticleCustom;
import com.gitsck.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result addArticle(@RequestBody GArticle gArticle, HttpSession session){
        return articleService.addArticle(gArticle,session);
    }

    @RequestMapping(value = "/init",method = RequestMethod.POST)
    public PageResult initList(@RequestBody GArticle gArticle,int page,int rows){
        return articleService.initList(page,rows,gArticle);
    }

    @RequestMapping(value = "/findesc",method = RequestMethod.GET)
    public Result findDesc(long aId){
        return articleService.findDesc(aId);
    }

    @RequestMapping(value = "/findhot",method = RequestMethod.GET)
    public Result findHot(){
        return articleService.findHot();
    }

    @RequestMapping("/admin/findall")
    public PageResult findALl(int page,int rows){
        List<GArticleCustom> aLl = articleService.findALl(page, rows);
        return new PageResult(((Page<GArticleCustom>) aLl).getTotal(),((Page<GArticleCustom>) aLl).getResult());
    }

    @RequestMapping("/article/del")
    public Result del(long id){
        return articleService.del(id);
    }
}
