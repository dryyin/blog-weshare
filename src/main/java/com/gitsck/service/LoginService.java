package com.gitsck.service;

import com.gitsck.entity.Result;
import com.gitsck.pojo.GUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface LoginService {

    Result login(GUser gUser, HttpSession session, HttpServletRequest request);
    Result userlogin(GUser gUser, HttpSession session, HttpServletRequest request);
    Result rigist(GUser gUser,HttpSession session,HttpServletRequest request);
}
