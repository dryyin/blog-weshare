package com.gitsck.controller;

import com.gitsck.mapper.GPvMapper;
import com.gitsck.pojo.GPv;
import com.gitsck.pojo.GPvExample;
import com.gitsck.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 页面跳转控制器
 */
@Controller

public class SkipController {

    @Autowired
    private GPvMapper gPvMapper;

    @RequestMapping("/")
    public ModelAndView index(HttpSession session){

        GPvExample gPvExample = new GPvExample();
        GPvExample.Criteria criteria = gPvExample.createCriteria();
        criteria.andPvDateEqualTo(TimeUtils.getTimeDate());
        List<GPv> gPvs = gPvMapper.selectByExample(gPvExample);
        if(gPvs.size() == 1){
            GPv gPv = gPvs.get(0);
            gPv.setPv(gPv.getPv()+1);
            gPvMapper.updateByPrimaryKey(gPv);
        }

        return new ModelAndView("user/index");
    }

    @RequestMapping("/w")
    public ModelAndView writeArticle(HttpSession session){
        return new ModelAndView("user/writearticle");
    }

    @RequestMapping("/admin")
    public ModelAndView indexBa(HttpSession session){
        session.invalidate();
        return new ModelAndView("admin/index");
    }

    @RequestMapping("/a")
    public ModelAndView article(HttpSession session){
        return new ModelAndView("admin/article");
    }

    @RequestMapping("/c")
    public ModelAndView count(HttpSession session){
        return new ModelAndView("admin/count");
    }

    @RequestMapping("/k")
    public ModelAndView kindManage(){
        return new ModelAndView("admin/kind");
    }

    @RequestMapping("/u")
    public ModelAndView user(){
        return new ModelAndView("admin/user");
    }

    @RequestMapping("/l")
    public ModelAndView login(){
        return new ModelAndView("user/login");
    }

    @RequestMapping("/r")
    public ModelAndView register(){
        return new ModelAndView("user/rigist");
    }

    @RequestMapping("/t")
    public ModelAndView tulin(){
        return new ModelAndView("user/tulin");
    }

    @RequestMapping("/read")
    public ModelAndView read(){
        return new ModelAndView("user/article");
    }

}
