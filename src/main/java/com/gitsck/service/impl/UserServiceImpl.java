package com.gitsck.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gitsck.entity.PageResult;
import com.gitsck.mapper.GUserMapper;
import com.gitsck.pojo.GUser;
import com.gitsck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private GUserMapper gUserMapper;

    @Override
    public PageResult findAllUsers(int page, int rows) {

        PageHelper.startPage(page,rows);

        Page<GUser> list = (Page<GUser>) gUserMapper.selectByExample(null);

        return new PageResult(list.getTotal(),list.getResult());
    }
}
