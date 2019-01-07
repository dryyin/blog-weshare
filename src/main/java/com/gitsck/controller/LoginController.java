package com.gitsck.controller;

import com.gitsck.entity.Result;
import com.gitsck.pojo.GUser;
import com.gitsck.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody GUser gUser, HttpSession session, HttpServletRequest request){
        return loginService.login(gUser,session,request);
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session){
        session.invalidate();
    }

    @RequestMapping(value = "/il",method = RequestMethod.GET)
    public Result isLogin(HttpSession session){

        GUser nuser = (GUser) session.getAttribute("nuser");

        if(nuser == null){
            return new Result(false,"未登录");
        }else{
            return new Result(true,"已登录",nuser);
        }
    }

    /*
    * 普通用户登录
    * */
    @RequestMapping(value = "/userlogin",method = RequestMethod.POST)
    public Result userlogin(@RequestBody GUser gUser, HttpSession session, HttpServletRequest request){
        return loginService.userlogin(gUser,session,request);
    }

    /*
     * 普通用户注册
     * */
    @RequestMapping(value = "/rigist",method = RequestMethod.POST)
    public Result rigist(@RequestBody GUser gUser,HttpSession session, HttpServletRequest request){
        return loginService.rigist(gUser,session,request);
    }

    /*
     * 普通用户是否登录
     * */
    @RequestMapping(value = "/useril",method = RequestMethod.GET)
    public Result isuserLogin(HttpSession session){

        GUser nuser = (GUser) session.getAttribute("unuser");

        if(nuser == null){
            return new Result(false,"未登录");
        }else{
            return new Result(true,"已登录",nuser);
        }
    }

}
