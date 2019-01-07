package com.gitsck.service.impl;

import com.gitsck.entity.Result;
import com.gitsck.mapper.GUserMapper;
import com.gitsck.pojo.GUser;
import com.gitsck.pojo.GUserExample;
import com.gitsck.service.LoginService;
import com.gitsck.util.IDUtils;
import com.gitsck.util.MD5Utils;
import com.gitsck.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private GUserMapper gUserMapper;

    @Override
    public Result login(GUser gUser, HttpSession session, HttpServletRequest request) {

        if(gUser.getuUsername() == null || gUser.getuPassword() == null){
            return new Result(false,"请填写完整");
        }

        String po_pass = MD5Utils.MD5(gUser.getuPassword());

        GUserExample example = new GUserExample();
        GUserExample.Criteria criteria = example.createCriteria();
        criteria.andUUsernameEqualTo(gUser.getuUsername());
        List<GUser> gUsers = gUserMapper.selectByExample(example);

        if(gUsers.size() == 1){
            if(gUsers.get(0).getuPassword().equals(po_pass)){
                if(gUsers.get(0).getuRole() == 1){
                    GUser user = gUsers.get(0);

                    user.setuIp(request.getRemoteAddr());

                    user.setuLastime(TimeUtils.getTime());

                    gUserMapper.updateByPrimaryKey(user);

                    user.setuPassword(null);

                    session.setAttribute("nuser",user);
                    return new Result(true,"登录成功");
                }else {
                    return new Result(false,"权限不够");
                }
            }else{
                return new Result(false,"密码错误");
            }
        }else {
            return new Result(false,"用户名不存在");
        }
    }



    @Override
    public Result userlogin(GUser gUser, HttpSession session, HttpServletRequest request) {
        if(gUser.getuUsername() == null || gUser.getuPassword() == null){
            return new Result(false,"请填写账号或者密码");
        }

        String po_pass = MD5Utils.MD5(gUser.getuPassword());

        GUserExample example = new GUserExample();
        GUserExample.Criteria criteria = example.createCriteria();
        criteria.andUUsernameEqualTo(gUser.getuUsername());
        List<GUser> gUsers = gUserMapper.selectByExample(example);

        if(gUsers.size() == 1){
            if(gUsers.get(0).getuPassword().equals(po_pass)){
                if(gUsers.get(0).getuRole() == 0 || gUsers.get(0).getuRole() == 1){
                    GUser user = gUsers.get(0);

                    user.setuIp(request.getRemoteAddr());

                    user.setuLastime(TimeUtils.getTime());

                    gUserMapper.updateByPrimaryKey(user);

                    user.setuPassword(null);

                    session.setAttribute("unuser",user);//---------------------------------
                    return new Result(true,"登录成功！");
                }else {
                    return new Result(false,"权限不够");
                }
            }else{
                return new Result(false,"密码错误");
            }
        }else {
            return new Result(false,"用户名不存在");
        }
    }

    @Override
    public Result rigist(GUser gUser,HttpSession session,HttpServletRequest request) {
        if(gUser.getuUsername() == null || gUser.getuPassword() == null){
            return new Result(false,"请填写账号或者密码!");
        }
        String po_pass = MD5Utils.MD5(gUser.getuPassword());

        GUserExample example = new GUserExample();
        GUserExample.Criteria criteria = example.createCriteria();
        criteria.andUUsernameEqualTo(gUser.getuUsername());
        List<GUser> gUsers = gUserMapper.selectByExample(example);
        if(gUsers.size() >= 1){
            return new Result(false,"该用户名已经被使用");
        }else{
            gUser.setuId(IDUtils.genItemId());
            gUser.setuPassword(MD5Utils.MD5(gUser.getuPassword()));
            gUser.setuIp(request.getRemoteAddr());
            gUser.setuLastime(TimeUtils.getTime());
            gUser.setuRole(0);
            gUserMapper.insert(gUser);
            gUser.setuPassword(null);
            session.setAttribute("unuser",gUser);//---------------------------------
            return new Result(true,"注册成功");
        }
    }
}
