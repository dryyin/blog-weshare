package com.gitsck.service;

import com.gitsck.entity.PageResult;

public interface UserService {

    PageResult findAllUsers(int page,int rows);
}
